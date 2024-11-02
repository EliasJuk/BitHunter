package main.functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class walletBalance {

  public static String search(String endereco) {
    String apiUrl = "https://blockchain.info/q/addressbalance/" + endereco;
    String saldo = null;

    try {
      URL url = new URL(apiUrl);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");

      // Lê a resposta da API
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuilder content = new StringBuilder();
      String inputLine;

      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }

      // Fecha o BufferedReader e a conexão
      in.close();
      con.disconnect();

      saldo = content.toString();
    } catch (Exception e) {
      System.out.println("Erro ao obter saldo. Verifique o endereço e tente novamente.");
      e.printStackTrace();
    }

    return saldo;
  }
}