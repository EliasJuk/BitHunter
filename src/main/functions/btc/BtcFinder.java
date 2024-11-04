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

public class BtcFinder {
  private dataPuzzle puzzle;

  public BtcFinder() {
    this.puzzle = new dataPuzzle();
  }

public void findKeyInRange() {
  try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Digite o número de Bits da carteira alvo (1:160): ");
      int challengeNumber = scanner.nextInt();
      challengeNumber--; // Decrementa para usar como índice

      // Verifica se o desafio existe
      if (challengeNumber < 0 || challengeNumber >= puzzle.ranges.size()) {
          System.out.println("Desafio inválido.");
          return;
      }

      // Obtém os intervalos de chaves para o desafio selecionado
      PuzzleClass selectedRange = puzzle.ranges.get(challengeNumber);
      BigInteger startIndex = selectedRange.getStartHex();
      BigInteger endIndex = selectedRange.getEndHex();

      // Pergunta ao usuário o endereço Bitcoin para comparar
      System.out.print("\nDigite o endereço Bitcoin para comparar: ");
      String targetAddress = scanner.next();

      // Calcula o total de combinações
      BigInteger totalCombinacoes = endIndex.subtract(startIndex).add(BigInteger.ONE);
      
      System.out.println("Total de combinações possíveis: " + totalCombinacoes);
      System.out.println("\nRanges:");
      System.out.println("DECIMAL:     " + startIndex + " até " + endIndex);
      System.out.println("HEXADECIMAL: " + startIndex.toString(16) + " até " + endIndex.toString(16));

      // Chama o método para gerar chaves e comparar
      addressComparte(startIndex, endIndex, targetAddress, challengeNumber);
  } catch (Exception e) {
      System.out.println("Ocorreu um erro: " + e.getMessage());
      e.printStackTrace();
  }
}

  // Método para comparar endereços gerados com o endereço alvo
  public static void addressComparte(BigInteger startIndex, BigInteger endIndex, String targetAddress,
      int challengeNumber) throws Exception {
    SecureRandom random = new SecureRandom();
    addressGenerator addrGen = new addressGenerator();

    String bitcoinAddress = "";
    String privateKeyHex = "";
    int count = 1;

    // Gera chaves até que o endereço correspondente seja encontrado
    while (!targetAddress.equals(bitcoinAddress)) {
      count++;

      // Gera uma chave aleatória dentro do intervalo
      BigInteger hexRandomKey = startIndex.add(new BigInteger(endIndex.subtract(startIndex).bitLength(), random));

      // Converte o valor aleatório para hexadecimal
      privateKeyHex = hexRandomKey.toString(16);

      // Gera a chave pública e o endereço
      String compressedPublicKey = publicKeyGenerate.generatePublicKey(privateKeyHex);
      bitcoinAddress = addrGen.generate(compressedPublicKey);

      // Imprime informações das chaves geradas e tentativas
      System.out.printf("\rPrivate: %s | Public: %s | Address: %s | Attempts: %d",
          privateKeyHex, compressedPublicKey, bitcoinAddress, count);

      System.out.flush();
    }

    System.out.println("\nWin: " + privateKeyHex);

    // Preenche a privateKeyHex com zeros à esquerda - 64 caracteres
    privateKeyHex = String.format("%064x", new BigInteger(privateKeyHex, 16));

    // Quando os endereços forem iguais, armazena em um arquivo TXT
    KeyDataLogger.writeToFile("FoundKeys.txt",
        "Challenge: " + (challengeNumber + 1) + " - Attempts: " + count + " - PrivateKey: " + privateKeyHex);
  }

  public static void main(String[] args) {
    BtcFinder keyFinder = new BtcFinder();
    keyFinder.findKeyInRange();
  }
}