package ru.fafurin.lesson2.task6;

public abstract class Multimedia {
    public String title;
    public String artistName;
    public String genre;
    public String releaseDate;

    public Multimedia(String title, String artistName, String genre, String releaseDate) {
        this.title = title;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }
}
