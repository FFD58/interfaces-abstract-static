package ru.fafurin.lesson1.task4;

import java.util.Scanner;

public class TableScanner {

    private Scanner scanner = new Scanner(System.in);

    public Row[] scanTable() {
        System.out.print("Please enter header of left column: ");
        String headerLeft = this.scanner.nextLine();
        System.out.print("Please enter header of right column: ");
        String headerRight = this.scanner.nextLine();
        Row header = new Row(headerLeft, headerRight);
        System.out.print("Please enter how many rows you will have in a table: ");
        int count = this.scanner.nextInt();

        Row[] table = new Row[count + 1];
        table[0] = header;

        for (int x = 1; x < count + 1; x++) {
            System.out.println("Enter " + x + " row:");
            System.out.println("left: ");
            String left = this.scanner.next();
            System.out.println("right: ");
            String right = this.scanner.next();
            Row row = new Row(left, right);
            table[x] = row;
        }
        return table;
    }
}
