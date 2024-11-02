package main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import utils.ColorPalette;
import utils.ConsoleClear;

public class main {
	public static void main(String args[]) throws Exception, NoSuchAlgorithmException{        
		while(true){
			ConsoleClear.clearConsole();
			
			System.out.println(ColorPalette.CYAN + "╔═══════════════════════════════╗" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║                               ║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║"+ColorPalette.PINK+"          BIT HUNTER           "+ColorPalette.CYAN+"║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║"+ColorPalette.YELLOW+"             v0.1              "+ColorPalette.CYAN+"║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║                               ║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "╚═══════════════════════════════╝" + ColorPalette.RESET);
			System.out.print("");
			System.out.println(
					"-------------------------------------------\n"+
					" 1 - CONVERT PRIVATE KEY TO WIF\n" +
					" 2 - GENERATE PUBLIC KEY\n" +
					" 3 - GENERATE BTC ADDRESS\n" +
					"-------------------------------------------\n"+
					" 4 - EllipticTools\n" +
					" 5 - RIPDM168 COMPARE\n" +
					"-------------------------------------------\n"+
					" 0 - EXIT\n");

			System.out.print(ColorPalette.YELLOW + "Choose an option: " + ColorPalette.RESET);
			Scanner scanner = new Scanner(System.in);
			int scannerMenu = scanner.nextInt();

			switch (scannerMenu) {
				case 1:
					callFunctions.wifGenerate();
					break;
				case 2:
					callFunctions.publicKeyGenerate();
					break;
				case 3:
					callFunctions.addressGenerate();
					break;
				case 4:
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
