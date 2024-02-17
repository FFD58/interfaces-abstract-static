package ru.fafurin.lesson3.task8;

public class AudioBook extends Multimedia {
    private String description;

    public AudioBook(String title, String artistName, String genre, String releaseDate, String description) {
        super(title, artistName, genre, releaseDate);
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Audiobook\nTitle: %s\nAuthor: %s\nGenre: %s\nRelease date: %s\nDescription: %s",
                this.title, this.artistName, this.genre, this.releaseDate, this.description
        );
    }
}
