package main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import utils.ColorPalette;
import utils.ConsoleClear;
import main.functions.*;


public class callFunctions {
  
  public static void wifGenerate() {
    ConsoleClear.clearConsole();
    System.out.println("Converting private key to WIF...");
    System.out.println(ColorPalette.GREEN
        + "Example: aca5882db643df97cc4b39608b258f7be8b53b6f38a2c1f04b1e77b180a872bb" + ColorPalette.RESET);
    System.out.println("");

    System.out.print("INFORME SUA PRIVATE KEY: ");
    Scanner scanner = new Scanner(System.in);
    String privateKeyHex = scanner.nextLine();

    System.out.println(ColorPalette.YELLOW + "\nWIF: " + wifGenerate.KeyToWIF(privateKeyHex, true) + ColorPalette.RESET);

    Pause();
  }

  public static void publicKeyGenerate() throws NoSuchAlgorithmException{
    ConsoleClear.clearConsole();
    System.out.println("Converting Private Key to Public Key...");
    System.out.println(ColorPalette.GREEN 
        + "Example: aca5882db643df97cc4b39608b258f7be8b53b6f38a2c1f04b1e77b180a872bb" + ColorPalette.RESET);

    System.out.print("\nINFORME SUA PRIVATE KEY: ");
    Scanner scanner = new Scanner(System.in);
    String privateKey = scanner.nextLine();

    String compressedPublicKey = publicKeyGenerate.generatePublicKey(privateKey);


    System.out.println(ColorPalette.YELLOW + "\nCHAVE PUBLICA COMPRIMIDA: " + compressedPublicKey + ColorPalette.RESET);

    Pause();
  }

  public static void addressGenerate() throws Exception {
    ConsoleClear.clearConsole();
    System.out.println("Converting Private Key to Public Key...");
    System.out.println(ColorPalette.GREEN
        + "Example: 036a62ce9e906683297bb548826b4d811e63adb57a2e3b2c429239d554846e6378" + ColorPalette.RESET);

    System.out.print("\nINFORME SUA PUBLIC KEY: ");
    Scanner scanner = new Scanner(System.in);
    String publickey = scanner.nextLine();

    addressGenerator addgenerate = new addressGenerator();
    System.out.println(ColorPalette.YELLOW + "\nAddress: " + addgenerate.generate(publickey) + ColorPalette.RESET);

    Pause();
  }

  public static void getBalance(){
    ConsoleClear.clearConsole();
    System.out.println("Getting Wallet Balance...");
    System.out.println(ColorPalette.GREEN+ "Example: 1FdZveg11QerSt88RVyXw1vKvYj4zya47g" + ColorPalette.RESET);
    
    Scanner scanner = new Scanner(System.in);
    System.out.print("\nDigite o endereço da carteira pública: ");
    String endereco = scanner.nextLine();

    System.out.print("\n");
    String saldo = walletBalance.search(endereco);
    System.out.println("Saldo da carteira: " + saldo + " satoshis");

    Pause();
  }

  // Aguarda o usuário pressionar uma tecla
  public static void Pause() {
    System.out.print(ColorPalette.MAGENTA + "\n\n\nPRECIONE UMA TECLA PARA SAIR!" + ColorPalette.RESET);
    Scanner pause = new Scanner(System.in);
    pause.nextLine();
  }
}