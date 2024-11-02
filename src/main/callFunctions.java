package main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import main.functions.wifGenerate;
import main.functions.addressGenerator;
import main.functions.publicKeyGenerate;
import utils.ColorPalette;
import utils.ConsoleClear;

public class callFunctions {
  
  public static void wifGenerate() {
    ConsoleClear.clearConsole();
    System.out.println("Converting private key to WIF...\n");
    System.out.println(ColorPalette.GREEN
        + "PrivateKey exp.: aca5882db643df97cc4b39608b258f7be8b53b6f38a2c1f04b1e77b180a872bb" + ColorPalette.RESET);
    System.out.println("");

    System.out.print("INFORME SUA PRIVATE KEY: ");
    Scanner scanner = new Scanner(System.in);
    String privateKeyHex = scanner.nextLine();

    System.out.println(ColorPalette.PINK + "\nWIF: " + wifGenerate.KeyToWIF(privateKeyHex, true));

    Pause();
  }

  public static void publicKeyGenerate() throws NoSuchAlgorithmException{
    ConsoleClear.clearConsole();
    System.out.println("Converting Private Key to Public Key...\n");
    System.out.println(ColorPalette.GREEN + "PrivateKey exp.: aca5882db643df97cc4b39608b258f7be8b53b6f38a2c1f04b1e77b180a872bb" + ColorPalette.RESET);

    System.out.print("INFORME SUA PRIVATE KEY: ");
    Scanner scanner = new Scanner(System.in);
    String privateKey = scanner.nextLine();

    String compressedPublicKey = publicKeyGenerate.generatePublicKey(privateKey);


    System.out.println(ColorPalette.PINK + "CHAVE PUBLICA COMPRIMIDA: " + compressedPublicKey + ColorPalette.RESET);

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
    System.out.print("Address: ");
    System.out.println(ColorPalette.YELLOW + addgenerate.generate(publickey) + ColorPalette.RESET);

    Pause();
  }

  // Aguarda o usuário pressionar uma tecla
  public static void Pause() {
    System.out.print(ColorPalette.MAGENTA + "\nPRECIONE UMA TECLA PARA SAIR!" + ColorPalette.RESET);
    Scanner pause = new Scanner(System.in);
    pause.nextLine();
  }
}