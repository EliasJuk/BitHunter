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
  private rangeData puzzle;

  public BtcFinder() {
    this.puzzle = new rangeData();
    puzzle.Puzzle(); // Inicializa os intervalos do puzzle
  }

  // Método para encontrar a chave no intervalo especificado pelo usuário.
  public void findKeyInRange() {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Digite o número do desafio (1:120): ");
      int challengeNumber = scanner.nextInt();
      challengeNumber--; // Decrementa para usar como índice

      // Verifica se o desafio existe
      if (challengeNumber < 0 || challengeNumber >= puzzle.ranges.size()) {
        System.out.println("Desafio inválido.");
        return;
      }

      // Obtém os intervalos de chaves para o desafio selecionado
      BigInteger startIndex = puzzle.ranges.get(challengeNumber).getStartHex();
      BigInteger endIndex = puzzle.ranges.get(challengeNumber).getEndHex();

      System.out.println("\nIntervalo de chaves: " + startIndex + " até " + endIndex);

      System.out.print("Digite o endereço Bitcoin para comparar: ");
      String targetAddress = scanner.next();

      // Chama o método para gerar chaves e comparar
      addressComparte(startIndex, endIndex, targetAddress, challengeNumber);
    } catch (Exception e) {
      System.out.println("Ocorreu um erro: " + e.getMessage());
      e.printStackTrace();
    }
  }


  // Método para comparar endereços gerados com o endereço alvo dentro de um intervalo específico.
  public static void addressComparte(BigInteger startIndex, BigInteger endIndex, String targetAddress,
      int challengeNumber)
      throws Exception {
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

      // Converte o valor randomico para hexadecimal
      privateKeyHex = hexRandomKey.toString(16);

      // Gera a chave pública e o endereço
      String compressedPublicKey = publicKeyGenerate.generatePublicKey(privateKeyHex);
      bitcoinAddress = addrGen.generate(compressedPublicKey);

      // Imprime informações das chaves geradas e tentativas
      System.out.println("\nPrivate: " + privateKeyHex);
      System.out.println("Public: " + compressedPublicKey);
      System.out.println("Address: " + bitcoinAddress);
      System.out.println("Attempts: " + count);

      // Verifica se o endereço gerado corresponde ao alvo
      if (targetAddress.equals(bitcoinAddress)) {
        break; // Sai do loop se os endereços forem iguais
      }
    }
    
    System.out.println("Win: " + privateKeyHex);

    // Preenche a privateKeyHex com zeros à esquerda se necessário para ter 64 caracteres
    privateKeyHex = String.format("%064x", new BigInteger(privateKeyHex, 16));

    // Quando os endereços forem iguais, armazena em um arquivo TXT
    KeyDataLogger.writeToFile("FoundKeys.txt", "Challenge: " + (challengeNumber+1) + " - Attempts: " + count + " - PrivateKey: " + privateKeyHex);
  }

  public static void main(String[] args) {
    BtcFinder keyFinder = new BtcFinder();
    keyFinder.findKeyInRange();
  }
}