package main.functions;

import java.security.MessageDigest;
import java.util.Arrays;

import encoding.EncodingToolkit;
import encoding.RIPEMD160;

public class addressGenerator {
	private final RIPEMD160 ripemd160 = new RIPEMD160();

	public String generate(String compressedPublicKey) throws Exception {
		if (compressedPublicKey.length() != 66) {
			throw new IllegalArgumentException("Chave pública comprimida deve ter 66 caracteres.");
		}

		byte[] sha256Hash = sha256(EncodingToolkit.hexStringToByteArray(compressedPublicKey));
		byte[] ripemd160Hash = ripemd160.ripemd160Hash(sha256Hash); // Correctly call ripemd160Hash method

		byte[] versionedHash = new byte[ripemd160Hash.length + 1];
		versionedHash[0] = 0x00; // Version byte
		System.arraycopy(ripemd160Hash, 0, versionedHash, 1, ripemd160Hash.length);

		byte[] checksum = sha256(sha256(versionedHash));
		checksum = Arrays.copyOfRange(checksum, 0, 4); // Get first 4 bytes of the checksum

		byte[] binaryBitcoinAddress = new byte[versionedHash.length + 4];
		System.arraycopy(versionedHash, 0, binaryBitcoinAddress, 0, versionedHash.length);
		System.arraycopy(checksum, 0, binaryBitcoinAddress, versionedHash.length, 4);

		//System.out.println(EncodingToolkit.base58Encode(binaryBitcoinAddress));
		//Scanner pause = new Scanner(System.in);
		//pause.nextLine(); // Aguarda o usuário pressionar Enter

		return EncodingToolkit.base58Encode(binaryBitcoinAddress);
	}

	private static byte[] sha256(byte[] data) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		return digest.digest(data);
	}
}