package ru.fafurin.lesson5.task3;

import ru.fafurin.lesson5.FileManager;
import ru.fafurin.lesson5.task1.SongLyrics;
import ru.fafurin.lesson5.task4.SongNotFoundException;

import java.io.File;

public class DirectorySongLyrics extends SongLyrics {

    private final String folder = "songs";

    private FileManager fileManager = new FileManager();
    @Override
    public String getSongText(String artist, String title) {
        return this.findSongText(artist, title);
    }

    private String findSongText(String artist, String title) {
        File folder = new File(this.folder);
        File[] files = folder.listFiles();

        String filename = artist + " - " + title + ".txt";
        String fileContent = null;

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(filename)) {
                    fileContent = this.fileManager.getFileContent(file.getAbsolutePath());
                    break;
                }
            }
        } else throw new EmptyFolderException();
        if (fileContent == null) throw new SongNotFoundException();
        return fileContent;
    }
}
