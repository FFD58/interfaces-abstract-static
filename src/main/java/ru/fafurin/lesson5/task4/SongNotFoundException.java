package ru.fafurin.lesson5.task4;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException() {
        super("Song not found");
    }
}
