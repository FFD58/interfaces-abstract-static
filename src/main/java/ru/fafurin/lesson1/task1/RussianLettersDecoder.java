package ru.fafurin.lesson1.task1;

public class RussianLettersDecoder implements Decoder {

    private char[] russianLetters = new char[]{'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ',
            'ф', 'ы', 'в', 'а', 'п', 'р', 'о', 'л', 'д', 'ж', 'э',
            'я', 'ч', 'с', 'м', 'и', 'т', 'ь', 'б', 'ю', ' '};

    private char[] englishLetters = new char[]{'b', 'x', 'n', 'k', 'c', 'z', 'h', 'i', 'o', 'w', '1', '5',
            'g', '3', 'v', 'f', 'a', '6', 'l', 'r', 'j', '9', '2',
            'y', 'p', 't', 'd', '7', 'e', '0', '4', 'u', ']'};

    @Override
    public String encode(String source) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < source.length(); y++) {
            for (int x = 0; x < this.russianLetters.length; x++) {
                if (source.charAt(y) == this.russianLetters[x]) {
                    builder.append(this.englishLetters[x]);
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String decode(String encoded) {
        StringBuilder builder = new StringBuilder();
        for (int y = 0; y < encoded.length(); y++) {
            for (int x = 0; x < this.englishLetters.length; x++) {
                if (encoded.charAt(y) == this.englishLetters[x]) {
                    builder.append(this.russianLetters[x]);
                }
            }
        }
        return builder.toString();
    }
}
