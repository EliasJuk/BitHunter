package tests;

import java.nio.charset.StandardCharsets;
import encoding.RIPEMD160;

public class test_ripemd160 {
  public static void displayHash(byte[] hash) {
    for (byte b : hash) {
      System.out.printf("%02x", b);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    RIPEMD160 ripemd160 = new RIPEMD160();

    String inputString = "Hello, world!";
    
    byte[] hashResult = ripemd160.ripemd160Hash(inputString.getBytes(StandardCharsets.UTF_8));
    System.out.print("Hash in bytes: ");
    displayHash(hashResult);
  }
}