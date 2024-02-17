package ru.fafurin.lesson3.task8;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Multimedia)) return false;
        Multimedia record = (Multimedia) o;
        return this.title.equals(record.title)
                && this.artistName.equals(record.artistName)
                && this.genre.equals(record.genre)
                && this.releaseDate.equals(record.releaseDate);
    }

}
