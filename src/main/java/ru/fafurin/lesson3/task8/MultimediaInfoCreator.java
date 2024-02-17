package ru.fafurin.lesson3.task8;

import done.third.StringParser;

public class MultimediaInfoCreator {

    private StringParser stringParser = new StringParser();

    public Song getSongInfo(String source) {
        return new Song(
                stringParser.trimStringByTag(source, "trackName"),
                stringParser.trimStringByTag(source, "artistName"),
                stringParser.trimStringByTag(source, "primaryGenreName"),
                stringParser.parseDate(stringParser.trimStringByTag(source, "releaseDate")),
                stringParser.trimStringByTag(source, "previewUrl")
        );
    }

    public AudioBook getAudiobookInfo(String source) {
        return new AudioBook(
                stringParser.trimStringByTag(source, "collectionName"),
                stringParser.trimStringByTag(source, "artistName"),
                stringParser.trimStringByTag(source, "primaryGenreName"),
                stringParser.parseDate(stringParser.trimStringByTag(source, "releaseDate")),
                stringParser.trimStringByTwoTags(source, "description", "}")
        );
    }

    public Movie getMovieInfo(String source) {
        return new Movie(
                stringParser.trimStringByTag(source, "trackName"),
                stringParser.trimStringByTag(source, "artistName"),
                stringParser.trimStringByTag(source, "primaryGenreName"),
                stringParser.parseDate(stringParser.trimStringByTag(source, "releaseDate")),
                stringParser.trimStringByTwoTags(source, "longDescription", "}")
        );
    }

}
