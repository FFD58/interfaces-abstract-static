package ru.fafurin.lesson2.task6;

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
                "<title>%s</title>\n<artistName>%s</artistName>\n<primaryGenreName>%s</<primaryGenreName>>\n<releaseDate>%s</releaseDate>",
                this.title, this.artistName, this.genre, this.releaseDate
        );
    }
}
