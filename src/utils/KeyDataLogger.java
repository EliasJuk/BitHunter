package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class KeyDataLogger {
  public static void writeToFile(String nomeArquivo, String conteudo) {
    try {
      // Caminho para salvar o arquivo na pasta 'win' na raiz do projeto
      String caminho = "win/" + nomeArquivo; // Este caminho deve ser relativo à raiz do projeto

      // Cria a pasta 'win' se não existir
      File winFolder = new File("win");
      if (!winFolder.exists()) {
          winFolder.mkdir();
      }

      // Cria um arquivo no caminho especificado
      File arquivo = new File(caminho);
      System.out.println("\nArquivo será salvo em: " + arquivo.getAbsolutePath());

      // Escreve o conteúdo no arquivo
      BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, true));
      escritor.newLine();
      escritor.write(conteudo);
      escritor.close();

      System.out.println("Conteúdo adicionado com sucesso ao arquivo: " + caminho);
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao adicionar o conteúdo ao arquivo.");
      e.printStackTrace();
    }
  }
}