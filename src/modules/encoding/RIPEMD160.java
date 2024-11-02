package encoding;

import java.util.Arrays;

public class RIPEMD160 {
  int[] hashValues;
  int[] initialHashValues;
  int[] messageOrder;
  int[] outputOrder;
  int[][] rhoLeft = new int[5][16];
  int[][] rhoRight = new int[5][16];
  int[][] shiftAmounts = new int[][] {
      { 11, 14, 15, 12, 5, 8, 7, 9, 11, 13, 14, 15, 6, 7, 9, 8 },
      { 12, 13, 11, 15, 6, 9, 9, 7, 12, 15, 11, 13, 7, 8, 7, 7 },
      { 13, 15, 14, 11, 7, 7, 6, 8, 13, 14, 13, 12, 5, 5, 6, 9 },
      { 14, 11, 12, 14, 8, 6, 5, 5, 15, 12, 15, 14, 9, 9, 8, 6 },
      { 15, 12, 13, 13, 9, 5, 8, 6, 14, 11, 12, 11, 8, 6, 5, 5 }
  };
  int[] K1 = { 0x0, 0x5a827999, 0x6ed9eba1, 0x8f1bbcdc, 0xa953fd4e };
  int[] K2 = { 0x50a28be6, 0x5c4dd124, 0x6d703ef3, 0x7a6d76e9, 0x0 };

  public RIPEMD160() {
    hashValues = new int[] { 0x67452301, 0xefcdab89, 0x98badcfe, 0x10325476, 0xc3d2e1f0 };
    initialHashValues = hashValues.clone();
    messageOrder = new int[] { 7, 4, 13, 1, 10, 6, 15, 3, 12, 0, 9, 5, 2, 14, 11, 8 };
    outputOrder = new int[] { 5, 14, 7, 0, 9, 2, 11, 4, 13, 6, 15, 8, 1, 10, 3, 12 };
  }

  class Block {
    public final int blockCount;
    public final byte[] data;
  
    Block(int blockCount, byte[] data) {
      this.blockCount = blockCount;
      this.data = data;
    }
  }

  private void precalculateRho() {
    for (int a = 0; a < 16; a++) {
      rhoLeft[0][a] = a;
      rhoRight[0][a] = outputOrder[a];
      for (int b = 1; b < 5; b++) {
        rhoLeft[b][a] = messageOrder[rhoLeft[b - 1][a]];
        rhoRight[b][a] = messageOrder[rhoRight[b - 1][a]];
      }
    }
  }

  private int roundFunction(int round, int A, int B, int C) {
    return switch (round) {
      case 1 -> A ^ B ^ C;
      case 2 -> (A & B) | (~A & C);
      case 3 -> (A | ~B) ^ C;
      case 4 -> (A & C) | (B & ~C);
      case 5 -> A ^ (B | ~C);
      default -> 0;
    };
  }

  private byte[] concatenateArrays(final byte[] array1, byte[] array2) {
    byte[] joinedArray = Arrays.copyOf(array1, array1.length + array2.length);
    System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
    return joinedArray;
  }

  private int rotate(int input, int shift) {
    return (input << shift) | (input >>> (32 - shift));
  }

  private Block addPadding(byte[] input) {
    int bitLength = input.length * 8;

    input = concatenateArrays(input, new byte[] { (byte) 0x80 });
    int paddingLength;
    if ((input.length % 64) < 56) {
      paddingLength = 56 - (input.length % 64);
    } else if ((input.length % 64) == 56) {
      paddingLength = 0;
    } else {
      paddingLength = 64 - (input.length % 64) + 56;
    }

    paddingLength += 8;

    byte[] padding = new byte[paddingLength];
    Arrays.fill(padding, (byte) 0x0);
    input = concatenateArrays(input, padding);

    int startLength = input.length - 8;
    for (int i = 0; i < 8; i++) {
      input[startLength + i] = (byte) (bitLength & 0xFF);
      bitLength >>= 8;
    }
    return new Block(input.length / 64, input);
  }

  private void resetState() {
    hashValues = initialHashValues.clone();
    Arrays.stream(rhoLeft).forEach(arr -> Arrays.fill(arr, 0));
    Arrays.stream(rhoRight).forEach(arr -> Arrays.fill(arr, 0));
    precalculateRho();
  }

  public byte[] computeHash(byte[] input) {
    resetState();
    Block block = addPadding(input);

    for (int i = 0; i < block.blockCount; i++) {
      int[] message = new int[16];
      for (int k = 0; k < 16; k++) {
        int start = i * 64 + k * 4;
        message[k] = java.nio.ByteBuffer.wrap(Arrays.copyOfRange(block.data, start, start + 4))
            .order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
      }

      int[] leftState = Arrays.copyOf(hashValues, 5);
      int[] rightState = Arrays.copyOf(hashValues, 5);

      for (int a = 0; a < 5; a++) {
        for (int b = 0; b < 16; b++) {
          int V = leftState[0];
          V += roundFunction(a + 1, leftState[1], leftState[2], leftState[3]);
          processRound(V, message, leftState, a, b, rhoLeft, K1);

          V = rightState[0];
          V += roundFunction(5 - a, rightState[1], rightState[2], rightState[3]);
          processRound(V, message, rightState, a, b, rhoRight, K2);
        }
      }

      int V = hashValues[1] + leftState[2] + rightState[3];
      for (int a = 1; a < 5; a++) {
        hashValues[a] = hashValues[(a + 1) % 5] + leftState[(a + 2) % 5] + rightState[(a + 3) % 5];
      }
      hashValues[0] = V;
    }

    byte[] result = new byte[20];
    for (int a = 0; a < 5; a++) {
      for (int b = 0; b < 4; b++) {
        result[a * 4 + b] = (byte) (hashValues[a] & 0xFF);
        hashValues[a] >>= 8;
      }
    }

    return result;
  }

  private void processRound(int v, int[] message, int[] state, int a, int b, int[][] rho, int[] K) {
    v += message[rho[a][b]];
    v += K[a];
    v = rotate(v, shiftAmounts[a][rho[a][b]]);
    v += state[4];

    state[0] = state[4];
    state[4] = state[3];
    state[3] = rotate(state[2], 10);
    state[2] = state[1];
    state[1] = v;
  }

  public byte[] ripemd160Hash(byte[] input) {
    return computeHash(input);
  }
}