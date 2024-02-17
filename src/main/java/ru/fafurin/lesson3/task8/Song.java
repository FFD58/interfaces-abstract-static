package ru.fafurin.lesson3.task8;

public class Song extends Multimedia {

    private String previewUrl;
    public Song(String title, String artistName, String genre, String releaseDate, String previewUrl) {
        super(title, artistName, genre, releaseDate);
        this.previewUrl = previewUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    @Override
    public String toString() {
        return String.format(
                "Song:\nTitle: %s\nArtistName: %s\nGenre: %s\nRelease date: %s\nPreviewUrl: %s",
                this.title, this.artistName, this.genre, this.releaseDate, this.previewUrl
        );
    }
}
