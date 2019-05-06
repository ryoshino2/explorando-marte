package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileOpening {

    private String word;

    public FileOpening() {
        try {
            String file = ("./file/instruction.txt");
            BufferedReader readFile = Files.newBufferedReader(Paths.get(file));

            word = readFile.lines().collect(Collectors.joining("\n"));

            readFile.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }

    public String getWord() {
        return word;
    }
}
