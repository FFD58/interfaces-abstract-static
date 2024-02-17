package ru.fafurin.lesson2.task6;

public class AudioBook extends Multimedia {
    private String description;

    public AudioBook(String title, String artistName, String genre, String releaseDate, String description) {
        super(title, artistName, genre, releaseDate);
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Title: %s\nAuthor: %s\nGenre: %s\nRelease date: %s\nDescription: %s",
                this.title, this.artistName, this.genre, this.description, this.releaseDate
        );
    }
}
