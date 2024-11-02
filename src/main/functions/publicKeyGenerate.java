package main.functions;

import java.security.NoSuchAlgorithmException;
import elliptic.EllipticTools;

public class publicKeyGenerate {
  public static String generatePublicKey(String privateKey) throws NoSuchAlgorithmException {
    String compressedPublicKey = EllipticTools.main(privateKey);    

    return compressedPublicKey;
  }
}