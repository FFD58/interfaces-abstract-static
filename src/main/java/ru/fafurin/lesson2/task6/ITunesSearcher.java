package ru.fafurin.lesson2.task6;

import ru.fafurin.lesson2.StringParser;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ITunesSearcher {
    private final String URL = "https://itunes.apple.com/search?term=";
    private StringParser stringParser;
    private String searchLine;

    private Scanner scanner;

    public String getSearchLine() {
        return this.searchLine;
    }

    public ITunesSearcher(Scanner scanner, StringParser stringParser) {
        System.out.println("Welcome to close betta-testing of the ITunes Searcher ver. 0.2");
        System.out.println("Please, enter a search words...");
        this.scanner = scanner;
        this.stringParser = stringParser;
        this.searchLine = this.URL + scanner.nextLine().replace(" ", "+") + "&limit=1";
    }

    public void printMultimediaInfo() {
        try {
            String res = downloadWebPage(getSearchLine());
            String type = res.substring(res.indexOf("wrapperType") + 14, res.indexOf("\","));
            switch (type) {
                // track может быть и фильмом и песней
                case "track" -> {
                    // если фильм
                    if (res.contains("feature-movie")) System.out.println(getMovieInfo(res));
                        // иначе песня
                    else {
                        Song song = getSongInfo(res);
                        System.out.println(song);
                        playSong(song);
                    }
                }
                case "audiobook" -> System.out.println(getAudiobookInfo(res));
                default -> System.out.println("Sorry, nothing was found for your query...");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void playSong(Song song) {
        System.out.println("Do you want to play the fragment of this song?");
        String answer = this.scanner.nextLine();
        if (answer.equals("yes")) {
            String filename = saveToFile(song.getPreviewUrl(), song.title);
            openFile(filename);
        } else System.out.println("Have a nice day!");
    }

    private Song getSongInfo(String source) {
        return new Song(
                stringParser.trimStringByTag(source, "trackName"),
                stringParser.trimStringByTag(source, "artistName"),
                stringParser.trimStringByTag(source, "primaryGenreName"),
                stringParser.parseDate(stringParser.trimStringByTag(source, "releaseDate")),
                stringParser.trimStringByTag(source, "previewUrl")
        );
    }

    private AudioBook getAudiobookInfo(String source) {
        return new AudioBook(
                stringParser.trimStringByTag(source, "collectionName"),
                stringParser.trimStringByTag(source, "artistName"),
                stringParser.trimStringByTag(source, "primaryGenreName"),
                stringParser.parseDate(stringParser.trimStringByTag(source, "releaseDate")),
                stringParser.trimStringByTwoTags(source, "description", "}")
        );
    }

    private Movie getMovieInfo(String source) {
        return new Movie(
                stringParser.trimStringByTag(source, "trackName"),
                stringParser.trimStringByTag(source, "artistName"),
                stringParser.trimStringByTag(source, "primaryGenreName"),
                stringParser.parseDate(stringParser.trimStringByTag(source, "releaseDate")),
                stringParser.trimStringByTwoTags(source, "longDescription", "}")
        );
    }

    private static String saveToFile(String url, String filename) {
        String path = System.getProperty("user.dir") + "\\" + "music";
        Path dir;
        try (InputStream in = new URL(url).openStream()) {
            dir = Files.createDirectories(Paths.get(path));
            Files.copy(in, Paths.get(dir + "\\" + filename + ".m4a"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dir + "\\" + filename + ".m4a";
    }

    private String downloadWebPage(String url) {
        StringBuilder res = new StringBuilder();
        try {
            String line;
            URLConnection urlConnection = new URL(url).openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res.toString();
    }

    // открывает файл если это возможно
    private void openFile(String filename) {
        if (!Desktop.isDesktopSupported()) {
            System.out.println("File opening not supported!");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File(filename);
        System.out.println(file);
        try {
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
