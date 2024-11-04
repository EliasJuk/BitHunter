package main.functions.btc;

import java.math.BigInteger;

/**
 * 
 * @author captainjuk
 * 
 */

public class PuzzleClass {
  private int bits;
  private String startHex;
  private String endHex;
  private String publicKey;
  private String address;

  public PuzzleClass(int bits, String startHex, String endHex, String publicKey, String address) {
    this.bits = bits;
    this.startHex = startHex;
    this.endHex = endHex;
    this.publicKey = publicKey;
    this.address = address;
  }

  public int getBits() {
		return bits;
	}

	public BigInteger getStartHex() {
		return new BigInteger(startHex, 16);
	}

	public BigInteger getEndHex() {
		return new BigInteger(endHex, 16);
	}

  public String getAddress() {
		return address;
	}

  @Override
  public String toString() {
    return "bbc{" +
        "bits=" + bits +
        ", startHex='" + startHex + '\'' +
        ", endHex='" + endHex + '\'' +
        ", publicKey='" + publicKey + '\'' +
        ", address='" + address + '\'' +
        '}';
  }
}