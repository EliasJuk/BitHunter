package tests;

import java.math.BigInteger;

import main.functions.btc.HexRange;

public class test_HexRange {

  public static void main(String[] args) {
    HexRange finder = new HexRange();

    int bitsToFind = 6;
    try {
      HexRange range = finder.findRangeByBits(bitsToFind);
      System.out.println("Bits: " + range.getBits());
      System.out.println("Range Inicial: " + finder.toHexString(range.getStartHex()) + " | " + range.getStartHex());
      System.out.println("Range Final:   " + finder.toHexString(range.getEndHex()) + " | " + range.getEndHex());

      // Total de combinações possíveis
      BigInteger totalCombinacoes = finder.getEndHex().subtract(finder.getStartHex()).add(BigInteger.ONE);
      System.out.println("Total de combinações possíveis: " + totalCombinacoes);

      // Gera um valor hexadecimal aleatório dentro da faixa usando parâmetros
      String randomHex = finder.getRandomHex(range.getStartHex(), range.getEndHex());
      System.out.println("\nValor aleatório gerado (hex): " + randomHex);

      // Gera um valor decimal aleatório dentro da faixa usando parâmetros
      String randomDecimal = finder.getRandomDecimal(range.getStartHex(), range.getEndHex());
      System.out.println("Valor aleatório gerado (decimal): " + randomDecimal);

      // Gera a sequência dentro do range
      System.out.println("\nValores no intervalo:");
      finder.generateSequentially();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
