package ru.fafurin.lesson1;

import ru.fafurin.lesson1.task1.RussianLettersDecoder;
import ru.fafurin.lesson1.task2.MorseCodeDecoder;
import ru.fafurin.lesson1.task3.CharCodeDecoder;
import ru.fafurin.lesson1.task4.*;

// Урок 1. Интерфейсы
public class Main {
    public static void main(String[] args) {

// 1. Сделайте интерфейс Decoder. В нем два метода String encode(String source) и String decode(String encoded).
// Реализуйте этот интерфейс: пусть класс меняет русские символы на цифры и латиницу (ш на w, г на r и так далее), и наоборот
        RussianLettersDecoder decoder = new RussianLettersDecoder();
        System.out.println(decoder.encode("закодированное слово"));
        System.out.println(decoder.decode(decoder.encode("закодированное слово")));

// 2. Сделайте ещё одну реализацию Decoder: он будет шифровать и дешифровать азбуку морзе
        MorseCodeDecoder morseCodeDecoder = new MorseCodeDecoder();
        System.out.println(morseCodeDecoder.encode("закодированное слово"));
        System.out.println(morseCodeDecoder.decode(morseCodeDecoder.encode("закодированное слово")));

// 3. Еще одну реализацию: он будет менять символ на код символа ( который можно получить как (int)str.charAt)
        CharCodeDecoder charCodeDecoder = new CharCodeDecoder();
        System.out.println(charCodeDecoder.encode("закодированное слово"));
        System.out.println(charCodeDecoder.decode(charCodeDecoder.encode("закодированное слово")));

// 4. Доработать ConsoleTableWriter, чтобы длина левой колонки была одинаковой для всех строк и равна длине самой большой
        TableScanner tableScanner = new TableScanner();
        System.out.println("Please fill a table...");
        Row[] table = tableScanner.scanTable();
        ConsoleTableWriter tableWriter = new ConsoleTableWriter();
        tableWriter.writeTable(table);
        System.out.println("Table written to " + tableWriter.getOutputPlace());
    }
}
