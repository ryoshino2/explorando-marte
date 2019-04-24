package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileOpening {

    private String palavras;

    public FileOpening() {
        try {
            String arquivo = ("./file/instruction.txt");
            BufferedReader lerArquivo = Files.newBufferedReader(Paths.get(arquivo));

            palavras = lerArquivo.lines().collect(Collectors.joining("\n"));

            lerArquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

    public String getPalavras() {
        return palavras;
    }
}
