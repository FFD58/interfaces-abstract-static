package ru.fafurin.lesson5.task3;

public class EmptyFolderException extends RuntimeException {
    public EmptyFolderException() {
        super("This folder is empty");
    }
}
