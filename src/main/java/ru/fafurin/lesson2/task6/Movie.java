package ru.fafurin.lesson2.task6;

public class Movie extends Multimedia {

    private String description;

    public Movie(String title, String artistName, String genre, String releaseDate, String description) {
        super(title, artistName, genre, releaseDate);
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "{\"results\":\n[{" +
                        "\"title\": \"%s\",\n" +
                        "\"artistName\": \"%s\",\n" +
                        "\"genre\": \"%s\",\n" +
                        "\"releaseDate\": \"%s\",\n" +
                        "\"description\": \"%s\",\n}]}",
                this.title, this.artistName, this.genre, this.releaseDate, this.description
        );
    }
}
