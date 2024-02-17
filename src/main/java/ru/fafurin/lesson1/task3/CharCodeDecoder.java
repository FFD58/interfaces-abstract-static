package ru.fafurin.lesson1.task3;

import ru.fafurin.fifth.lesson1.task1.Decoder;

public class CharCodeDecoder implements Decoder {
    @Override
    public String encode(String source) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < source.length(); y++) {
            builder.append((int) source.charAt(y));
            builder.append(" ");
        }
        return builder.toString();
    }

    @Override
    public String decode(String encoded) {
        StringBuilder builder = new StringBuilder();
        int[] encodedArr = strToIntArr(encoded);
        for (int y = 0; y < encodedArr.length; y++) {
            builder.append((char) encodedArr[y]);
        }
        return builder.toString();
    }

    public int[] strToIntArr(String str) {
        String[] strArr = str.split(" ");
        int[] charCodes = new int[strArr.length];
        for (int x = 0; x < strArr.length; x++) {
            charCodes[x] = Integer.parseInt(strArr[x]);
        }
        return charCodes;
    }

}
