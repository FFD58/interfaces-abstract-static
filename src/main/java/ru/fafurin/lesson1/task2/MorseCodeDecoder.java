package ru.fafurin.lesson1.task2;

import ru.fafurin.fifth.lesson1.task1.Decoder;

public class MorseCodeDecoder implements Decoder {
    private char[] russianLetters = new char[]{'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ',
            'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э',
            'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю', ' '};

    private String[] morseCode = new String[]{".---", "-.-.", "..-", "-.-", ".", "-.", "--.", "----", "--.-", "--..", "....", "--.--",
            "..-.", "-.--", ".--", ".-", ".--.", ".-.", "---", ".-..", "-..", "...-", "..-..",
            ".-.-", "---.", "...", "--", "..", "-", "-..-", "-...", "..--", ".-.-.-"};
    @Override
    public String encode(String source) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < source.length(); y++) {
            for (int x = 0; x < this.russianLetters.length; x++) {
                if (source.charAt(y) == this.russianLetters[x]) {
                    builder.append(this.morseCode[x]);
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String decode(String encoded) {
        StringBuilder builder = new StringBuilder();
        String[] encodedArr = encoded.split(" ");
        for (int y = 0; y < encodedArr.length; y++) {
            for (int x = 0; x < this.morseCode.length; x++) {
                if (encodedArr[y].equals(this.morseCode[x])) {
                    builder.append(this.russianLetters[x]);
                }
            }
        }
        return builder.toString();
    }
}
