package ru.fafurin.lesson5.task4;

import ru.fafurin.lesson5.task1.SongLyrics;

public class ApiSongLyrics extends SongLyrics {

    private PageDownloader pageDownloader = new PageDownloader();

    private String delimiter = "%20";

    public String url = "https://api.lyrics.ovh/v1/";

    @Override
    public String getSongText(String author, String title) {
        this.makeUrl(author, title);
        String text;
        try {
            text = this.pageDownloader.downloadWebPage(this.url);
        } catch (RuntimeException e) {
            throw new SongNotFoundException();
        }
        return this.formatSongText(text);
    }

    private void makeUrl(String artist, String songTitle) {
        this.url = url + this.formatStringForUrl(artist) + "/" + this.formatStringForUrl(songTitle);
    }

    private String formatStringForUrl(String str) {
        return str.replace(" ", this.delimiter);
    }

    private String formatSongText(String text) {
        return text.
                replace("{\"lyrics\":\"Paroles de la chanson ", "").
                replace("\\n", "\n").
                replace("\\r", "\n").
                replace("\"}", "");
    }
}
