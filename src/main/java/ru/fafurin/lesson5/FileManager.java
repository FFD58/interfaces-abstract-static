package ru.fafurin.lesson5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public String getFileContent(String filename) {
        Path path = Paths.get(filename);
        String content = null;
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content;
    }
}
