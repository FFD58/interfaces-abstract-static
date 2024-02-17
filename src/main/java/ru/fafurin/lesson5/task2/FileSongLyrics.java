package ru.fafurin.lesson5.task2;

import ru.fafurin.lesson5.FileManager;
import ru.fafurin.lesson5.task1.SongLyrics;
import ru.fafurin.lesson5.task4.SongNotFoundException;

public class FileSongLyrics extends SongLyrics {

    private FileManager fileManager = new FileManager();
    private String filename = "songs.txt";

    private String fileDelimiter = "-----";

    @Override
    public String getSongText(String artist, String title) {
        return this.findSongText(artist, title);
    }

    private String findSongText(String artist, String title) {
        String result;
        String fileContent = this.fileManager.getFileContent(this.filename);
        if (!fileContent.contains(artist)) throw new SongNotFoundException();
        else {
            if (!fileContent.contains(title)) {
                throw new SongNotFoundException();
            } else {
                int startIndex = fileContent.indexOf(title);
                int endIndex = fileContent.indexOf(this.fileDelimiter, startIndex);
                result = artist + "\n" + fileContent.substring(startIndex,  endIndex - this.fileDelimiter.length());
            }
        }
        return result;
    }
}
