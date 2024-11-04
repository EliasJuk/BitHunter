package main.functions.btc;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

import main.functions.addressGenerator;
import main.functions.publicKeyGenerate;
import utils.KeyDataLogger;

/**
 * 
 * @author captainjuk
 * 
 */

public class BtcPuzzle {
  private static final String INVALID_CHALLENGE_MESSAGE = "Desafio inválido.";
  private static final String TOTAL_COMBINATIONS_MESSAGE = "Total de combinações possíveis: ";
  private static final String FOUND_KEY_LOG_MESSAGE = "FoundKeys.txt";

  private dataPuzzle puzzle;

  public BtcPuzzle() {
    this.puzzle = new dataPuzzle(); // Inicializa os dados do puzzle
  }

  public void findKeyInRange() {
    try (Scanner scanner = new Scanner(System.in)) {
      int challengeNumber = getChallengeNumber(scanner);
      if (challengeNumber < 0)
        return;

      PuzzleClass selectedRange = puzzle.ranges.get(challengeNumber);
      printRangeInfo(selectedRange);

      addressCompare(selectedRange);
    } catch (Exception e) {
      System.out.println("Ocorreu um erro: " + e.getMessage());
      e.printStackTrace();
    }
  }

  private int getChallengeNumber(Scanner scanner) {
    System.out.print("Digite o número do desafio (1:160): ");
    int challengeNumber = scanner.nextInt() - 1; // Decrementa para usar como índice
    if (challengeNumber < 0 || challengeNumber >= puzzle.ranges.size()) {
      System.out.println(INVALID_CHALLENGE_MESSAGE);
      return -1; // Retorna -1 em caso de desafio inválido
    }
    return challengeNumber;
  }

  private void printRangeInfo(PuzzleClass selectedRange) {
    BigInteger startIndex = selectedRange.getStartHex();
    BigInteger endIndex = selectedRange.getEndHex();

    BigInteger totalCombinacoes = endIndex.subtract(startIndex).add(BigInteger.ONE);
    System.out.println("\nRanges:");
    System.out.println("DECIMAL:     " + startIndex + " até " + endIndex);
    System.out.println("HEXADECIMAL: " + startIndex.toString(16) + " até " + endIndex.toString(16));
    System.out.println(TOTAL_COMBINATIONS_MESSAGE + totalCombinacoes + "\n");
  }

  private void addressCompare(PuzzleClass selectedRange) throws Exception {
    BigInteger startIndex = selectedRange.getStartHex();
    BigInteger endIndex = selectedRange.getEndHex();
    String targetAddress = selectedRange.getAddress();
    SecureRandom random = new SecureRandom();
    addressGenerator addrGen = new addressGenerator();

    String bitcoinAddress = "";
    String privateKeyHex = "";
    int count = 0;

    while (!targetAddress.equals(bitcoinAddress)) {
      count++;
      privateKeyHex = generateRandomKey(startIndex, endIndex, random);
      String compressedPublicKey = publicKeyGenerate.generatePublicKey(privateKeyHex);
      bitcoinAddress = addrGen.generate(compressedPublicKey);

      printAttemptInfo(privateKeyHex, compressedPublicKey, bitcoinAddress, count);
    }

    logFoundKey(selectedRange, privateKeyHex, count);
  }

  private String generateRandomKey(BigInteger startIndex, BigInteger endIndex, SecureRandom random) {
    BigInteger hexRandomKey = startIndex.add(new BigInteger(endIndex.subtract(startIndex).bitLength(), random));
    return hexRandomKey.toString(16); // Converte para hexadecimal
  }

  private void printAttemptInfo(String privateKeyHex, String compressedPublicKey, String bitcoinAddress, int count) {
    System.out.printf("\rPrivate: %s | Public: %s | Address: %s | Attempts: %d",
        privateKeyHex, compressedPublicKey, bitcoinAddress, count);
    System.out.flush(); // Atualiza o buffer para mostrar imediatamente no console
  }

  private void logFoundKey(PuzzleClass selectedRange, String privateKeyHex, int count) {
    privateKeyHex = String.format("%064x", new BigInteger(privateKeyHex, 16)); // Preenche com zeros à esquerda
    KeyDataLogger.writeToFile(FOUND_KEY_LOG_MESSAGE,
        "Challenge: " + (puzzle.ranges.indexOf(selectedRange) + 1) + " - Attempts: " + count + " - PrivateKey: "
            + privateKeyHex);
  }

  public static void main(String[] args) {
    BtcPuzzle keyFinder = new BtcPuzzle();
    keyFinder.findKeyInRange();
  }
}