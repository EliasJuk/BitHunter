package modules;

import utils.EncodingToolkit;

/**
 *
 * @author captainjuk
 * 
 */

public class WIFGenerator {
    public static String KeyToWIF(String privateKeyHex, boolean compressed) {
        try {
            // Adicionar o prefixo (0x80 para Bitcoin principal)
            String prefix = "80";
            String privateKeyWithPrefix = prefix + privateKeyHex;
            
            // Se for comprimido, adicionar o sufixo (0x01)
            if (compressed) {
                privateKeyWithPrefix += "01"; // Adiciona o sufixo para chaves comprimidas
            } else {
                System.out.println("PublicKey Uncompressed");
            }           
                        
            // Converter a CHAVE PRIVADA com os prefixos em bytes
            byte[] privateKeyBytes = EncodingToolkit.hexStringToByteArray(privateKeyWithPrefix);

            // Fazer HASH DUPLO SHA-256
            String hash1 = EncodingToolkit.sha256(privateKeyBytes);
            String hash2 = EncodingToolkit.sha256(EncodingToolkit.hexStringToByteArray(hash1));
            
            
            // Pegar os primeiros 4 bytes do hash duplo (checksum)
            String checksum = hash2.substring(0, 8);

            // Adicionar o checksum ao final da chave privada com o prefixo
            String finalKey = privateKeyWithPrefix + checksum;

            // Converter para Base58
            String wif = EncodingToolkit.base58Encode(EncodingToolkit.hexStringToByteArray(finalKey));
            
            
            return wif;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}