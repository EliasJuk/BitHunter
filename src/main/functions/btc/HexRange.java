package main.functions.btc;

import java.math.BigInteger;

/**
 *
 * @author captainjuk
 * 
 */

public class HexRange {
  public int bits;
  public BigInteger start;
  public BigInteger end;

  public HexRange(int bits, String startHex, String endHex) {
    this.bits = bits;
    this.start = new BigInteger(startHex, 16);
    this.end = new BigInteger(endHex, 16);
  }

  public int getBits() {
    return bits;
  }

  public BigInteger getStartHex() {
    return start;
  }

  public BigInteger getEndHex() {
    return end;
  }

  // Método para percorrer a faixa sequencialmente
  public void generateSequentially() {
    BigInteger current = start;
    while (current.compareTo(end) <= 0) {
      System.out.print(" "+current.toString(16));   // Imprime o valor em hexadecimal
      current = current.add(BigInteger.ONE);              // Incrementa
    }
  }

  // Método para gerar um valor aleatório dentro da faixa
  public String getRandomHex() {
    BigInteger range = end.subtract(start).add(BigInteger.ONE);
    BigInteger randomValue = new BigInteger(range.bitLength(), new java.security.SecureRandom());
    return start.add(randomValue.mod(range)).toString(16);
  }

  public static void main(String[] args) {
    // Definindo um intervalo de exemplo
    int bits = 8;             // Número de bits
    String startHex = "80";   // Início do intervalo em hexadecimal
    String endHex = "ff";     // Fim do intervalo em hexadecimal

    // Criando uma instância de HexRange
    HexRange hexRange = new HexRange(bits, startHex, endHex);

    // Testando o método getBits
    System.out.println("Número de bits: " + hexRange.getBits());

    // Métodos getStartHex e getEndHex
    System.out.println("Início do intervalo (hex): " + hexRange.getStartHex().toString(16));
    System.out.println("Fim do intervalo (hex): " + hexRange.getEndHex().toString(16));

    // Total de combinações possíveis
    BigInteger totalCombinacoes = hexRange.getEndHex().subtract(hexRange.getStartHex()).add(BigInteger.ONE);
    System.out.println("Total de combinações possíveis: " + totalCombinacoes);

    // Gera um valor aleatório dentro da faixa
    String randomHex = hexRange.getRandomHex();
    System.out.println("\nValor aleatório gerado (hex): " + randomHex);

    // Sequencia
    System.out.println("\nValores no intervalo:");
    hexRange.generateSequentially();
  }
}