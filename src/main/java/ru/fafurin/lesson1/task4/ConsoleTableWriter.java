package ru.fafurin.lesson1.task4;

public class ConsoleTableWriter implements TableWriter {

    private final String outputPlace = "console";

    @Override
    public void writeTable(Row[] table) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < table.length; x++) {
            int maxLength = this.maxLength(table);
            Row row = table[x];
            builder.append(row.left);
            int strLength = row.left.length();
            if (strLength < maxLength) builder.append(this.addWhitespaces(maxLength - strLength));
            builder.append("\t|\t");
            builder.append(row.right);
            builder.append("\n");
        }
        System.out.println(builder);
    }

    @Override
    public String getOutputPlace() {
        return this.outputPlace;
    }

    private int maxLength(Row[] table) {
        int maxLength = 0;
        for (int x = 0; x < table.length; x++) {
            Row row = table[x];
            if (row.left.length() > maxLength) maxLength = row.left.length();
        }
        return maxLength;
    }

    private String addWhitespaces(int count) {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < count; x++) {
            builder.append(" ");
        }
        return builder.toString();
    }

}
