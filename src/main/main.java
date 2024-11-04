package main;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import main.functions.btc.BtcFinder;
import main.functions.btc.BtcPuzzle;
import utils.ColorPalette;
import utils.ConsoleClear;

public class main {
	public static void main(String args[]) throws Exception, NoSuchAlgorithmException {
		while (true) {
			ConsoleClear.clearConsole();

			System.out.println(ColorPalette.CYAN + "╔═══════════════════════════════╗" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║                               ║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║" + ColorPalette.PINK + "          BIT HUNTER           "
					+ ColorPalette.CYAN + "║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║" + ColorPalette.YELLOW + "             v0.1              "
					+ ColorPalette.CYAN + "║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "║                               ║" + ColorPalette.RESET);
			System.out.println(ColorPalette.CYAN + "╚═══════════════════════════════╝" + ColorPalette.RESET);
			System.out.print("");
			System.out.println(
					"-------------------------------------------\n" +
							" 1 - CONVERT PRIVATE KEY TO WIF\n" +
							" 2 - GENERATE PUBLIC KEY\n" +
							" 3 - GENERATE BTC ADDRESS\n" +
							"-------------------------------------------\n" +
							" 4 - Target Wallet Address\n" +
							" 5 - Puzzle Wallet\n" +
							" 6 - RIPDM168 COMPARE\n" +
							"-------------------------------------------\n" +
							" 9 - Wallet Balance\n" +
							"-------------------------------------------\n" +
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
					BtcFinder btcfinder = new BtcFinder();
					btcfinder.findKeyInRange();
					break;
				case 5:
					BtcPuzzle btcpuzzle = new BtcPuzzle();
					btcpuzzle.findKeyInRange();
					break;
				case 9:
					callFunctions.getBalance();
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
