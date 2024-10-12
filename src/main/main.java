package main;

import java.util.Scanner;
import utils.ColorPalette;
import utils.ConsoleClear;

public class main {
    public static void main(String args[]){        
        while(true){
            ConsoleClear.clearConsole();
            
            System.out.println(ColorPalette.CYAN + "╔═══════════════════════════════╗" + ColorPalette.RESET);
            System.out.println(ColorPalette.CYAN + "║                               ║" + ColorPalette.RESET);
            System.out.println(ColorPalette.CYAN + "║"+ColorPalette.PINK+"       SatoshiToolBox Menu     "+ColorPalette.CYAN+"║" + ColorPalette.RESET);
            System.out.println(ColorPalette.CYAN + "║"+ColorPalette.YELLOW+"             v0.1              "+ColorPalette.CYAN+"║" + ColorPalette.RESET);
            System.out.println(ColorPalette.CYAN + "║                               ║" + ColorPalette.RESET);
            System.out.println(ColorPalette.CYAN + "╚═══════════════════════════════╝" + ColorPalette.RESET);
            System.out.println(ColorPalette.YELLOW + "Choose an option:" + ColorPalette.RESET);
            System.out.println(
                    " 1 - CONVERT PRIVATE KEY TO WIF\n" +
                    " 2 - GENERATE PUBLIC KEY\n" +
                    " 3 - GENERATE BTC ADDRESS\n" +
                    " 0 - EXIT");

            Scanner scanner = new Scanner(System.in);
            int scannerMenu = scanner.nextInt();

            switch (scannerMenu) {
                case 1:
                    System.out.println("Converting private key to WIF...\n");
                    break;
                case 2:
                    System.out.println("Generating public key...");
                    break;
                case 3:
                    System.out.println("Generating Bitcoin address...");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }    
}