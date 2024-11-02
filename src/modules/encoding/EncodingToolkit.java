package encoding;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncodingToolkit {

  // Converter um array de bytes em uma string hexadecimal
  public static String byteArrayToHexString(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  // Converter uma string hexadecimal em um array de bytes
  public static byte[] hexStringToByteArray(String hex) {
    int len = hex.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
          + Character.digit(hex.charAt(i + 1), 16));
    }
    return data;
  }

  // Calcular SHA-256
  public static String sha256(byte[] input) throws Exception {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hash = digest.digest(input);

    return byteArrayToHexString(hash);
  }

  // Codificar em Base58
  public static String base58Encode(byte[] input) {
    BigInteger bigInt = new BigInteger(1, input);
    String base58Chars = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    StringBuilder result = new StringBuilder();
    while (bigInt.compareTo(BigInteger.ZERO) > 0) {
      BigInteger[] divmod = bigInt.divideAndRemainder(BigInteger.valueOf(58));
      result.insert(0, base58Chars.charAt(divmod[1].intValue()));
      bigInt = divmod[0];
    }
    // Adiciona '1' para cada byte zero no início
    for (int i = 0; i < input.length && input[i] == 0; i++) {
      result.insert(0, '1');
    }
    return result.toString();
  }
}