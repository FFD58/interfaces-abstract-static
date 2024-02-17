package ru.fafurin.lesson1.task4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileTableWriter implements TableWriter {

    private String filename;

    public TextFileTableWriter(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeTable(Row[] table) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.filename));
            for (Row row : table) {
                bufferedWriter.write(row.left + "\t\t\t|\t\t\t" + row.right + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getOutputPlace() {
        return "text file: " + this.filename;
    }
}
