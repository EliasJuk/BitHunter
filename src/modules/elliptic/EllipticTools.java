package handlers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author captainjuk
 * 
 */

public class EllipticTools {
  // Constantes da curva secp256k1
  private static final BigInteger p = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F",
      16); // O campo primo
  private static final BigInteger a = BigInteger.ZERO; // Coeficiente 'a' da curva secp256k1
  private static final BigInteger b = BigInteger.valueOf(7); // Coeficiente 'b' da curva secp256k1
  private static final BigInteger Gx = new BigInteger(
      "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16); // Coordenada x do ponto gerador
  private static final BigInteger Gy = new BigInteger(
      "483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8", 16); // Coordenada y do ponto gerador
  private static final BigInteger n = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141",
      16); // Ordem do ponto gerador

  // Ponto na curva
  public static class Point {
    public BigInteger x;
    public BigInteger y;

    public Point(BigInteger x, BigInteger y) {
      this.x = x;
      this.y = y;
    }
  }

  // Função para multiplicar um ponto por um escalar na curva elíptica (Ponto *
  // escalar)
  public static Point scalarMultiply(BigInteger k, Point P) {
    Point result = null; // Iniciar em infinito (ponto neutro)
    Point addend = P; // Ponto a ser adicionado repetidamente

    // Multiplicação escalar usando o algoritmo "Double and Add"
    while (k.signum() != 0) {
      if (k.testBit(0)) {
        if (result == null) {
          result = addend;
        } else {
          result = pointAdd(result, addend);
        }
      }
      addend = pointDouble(addend);
      k = k.shiftRight(1);
    }

    return result;
  }

  // Função para somar dois pontos na curva elíptica
  public static Point pointAdd(Point P, Point Q) {
    if (P == null)
      return Q;
    if (Q == null)
      return P;

    BigInteger lambda = (Q.y.subtract(P.y)).multiply(Q.x.subtract(P.x).modInverse(p)).mod(p);
    BigInteger xr = lambda.multiply(lambda).subtract(P.x).subtract(Q.x).mod(p);
    BigInteger yr = lambda.multiply(P.x.subtract(xr)).subtract(P.y).mod(p);

    return new Point(xr, yr);
  }

  // Função para dobrar um ponto na curva elíptica
  public static Point pointDouble(Point P) {
    BigInteger lambda = (P.x.multiply(P.x).multiply(BigInteger.valueOf(3)).add(a))
        .multiply(P.y.multiply(BigInteger.valueOf(2)).modInverse(p)).mod(p);
    BigInteger xr = lambda.multiply(lambda).subtract(P.x.multiply(BigInteger.valueOf(2))).mod(p);
    BigInteger yr = lambda.multiply(P.x.subtract(xr)).subtract(P.y).mod(p);

    return new Point(xr, yr);
  }

  // Geração da chave pública a partir da chave privada
  public static Point generatePublicKey(BigInteger privateKey) {
    Point G = new Point(Gx, Gy);
    return scalarMultiply(privateKey, G);
  }

  // Função para calcular o RIPEMD-160 após o SHA-256
  public static byte[] sha256Ripemd160(byte[] input) throws NoSuchAlgorithmException {
    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
    byte[] sha256Hash = sha256.digest(input);

    MessageDigest ripemd160 = MessageDigest.getInstance("RIPEMD160");
    return ripemd160.digest(sha256Hash);
  }

  // Gera chave publica comprimida
  public static String generateCompressedPublicKey(String x, String y) {
    if (x.length() != 64 || y.length() != 64) {
      throw new IllegalArgumentException("As coordenadas x e y devem ter 64 caracteres.");
    }

    // Verificar se y é par ou ímpar
    BigInteger yCoord = new BigInteger(y, 16);
    String prefix = yCoord.testBit(0) ? "03" : "02"; // Testa se o bit menos significativo está definido (ímpar)

    // Concatenar o prefixo com a coordenada x
    // return prefix + String.format("%064x", x);
    return prefix + x;
  }

  public static String main(String PPkey) throws NoSuchAlgorithmException {

    // Chave privada de exemplo
    BigInteger privateKey = new BigInteger(PPkey, 16);
    // System.out.println(privateKey);

    // Geração da chave pública
    Point publicKey = generatePublicKey(privateKey);

    // Certifique-se de que a coordenada x e y sejam de 64 caracteres
    String xHex = String.format("%064x", publicKey.x);
    String yHex = String.format("%064x", publicKey.y);

    // System.out.println("Chave Publica (x): " + publicKey.x.toString(16));
    // System.out.println("Chave Publica (y): " + publicKey.y.toString(16));

    String Compressed = generateCompressedPublicKey(xHex, yHex);
    String Uncompressed = "04" + xHex + yHex;

    // System.out.println("Compressed:: " + Compressed);
    // System.out.println("Uncompressed: " + Uncompressed);
    return Compressed;
  }
}