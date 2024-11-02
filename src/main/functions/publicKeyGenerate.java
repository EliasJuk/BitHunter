package main.functions;

import java.security.NoSuchAlgorithmException;
import elliptic.Secp256k1;

public class publicKeyGenerate {
  public static String generatePublicKey(String privateKey) throws NoSuchAlgorithmException {
    String compressedPublicKey = Secp256k1.main(privateKey);    

    return compressedPublicKey;
  }
}