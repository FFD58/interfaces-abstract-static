package ru.fafurin.lesson3.task8;

import java.util.Scanner;

public class ITunesSearcher {

    private Multimedia[] multimediaList;
    private final String URL = "https://itunes.apple.com/search?term=";

    private MultimediaInfoCreator multimediaInfoCreator = new MultimediaInfoCreator();
    private String searchLine;

    private String requestString;

    private PageDownloader pageDownloader = new PageDownloader();
    private Scanner scanner = new Scanner(System.in);

    private int multimediaLimit = 3;

    public ITunesSearcher() {
        this.multimediaList = new Multimedia[50];
        System.out.println("Welcome to close betta-testing of the ITunes Searcher ver. 0.3");
        System.out.print("Please, enter a search line... ");
        this.requestString = scanner.nextLine().replace(" ", "+");
        this.searchMultimedia();
        this.printMultimediaList();
        this.continueSearch();
    }

    private void continueSearch() {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("Do you want to continue the search?");
            System.out.print("Please, enter yes or no... ");
            if (this.scanner.nextLine().toLowerCase().equals("yes")) {
                this.multimediaLimit += 3;
                this.searchMultimedia();
                this.printMultimediaList();
            } else {
                isContinue = false;
                System.out.println("Have a nice day!");
            }
        }
    }

    public void searchMultimedia() {
        this.searchLine = this.URL + this.requestString + "&limit=" + this.multimediaLimit;
        try {
            String res = this.pageDownloader.downloadWebPage(this.searchLine);
            for (int x = 0; x < this.multimediaLimit; x++) {
                int currentIndex = res.indexOf("{");
                int endIndex = res.indexOf("}", currentIndex + 1);
                String multimedia = res.substring(currentIndex, endIndex + 1);
                String type = multimedia.substring(multimedia.indexOf("wrapperType") + 14, multimedia.indexOf("\","));
                this.sortMultimedia(x, multimedia, type);
                res = res.replace(multimedia, "");
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean checkMismatchMultimedia(Multimedia multimedia) {
        for (int x = 0; x < this.multimediaLimit; x++) {
            if (multimedia.equals(this.multimediaList[x])) return false;
        }
        return true;
    }

    private void sortMultimedia(int iteration, String multimedia, String type) {
        switch (type) {
            case "track" -> {
                if (multimedia.contains("feature-movie")) {
                    Movie movie = this.multimediaInfoCreator.getMovieInfo(multimedia);
                    if (this.checkMismatchMultimedia(movie)) this.multimediaList[iteration] = movie;
                } else {
                    Song song = this.multimediaInfoCreator.getSongInfo(multimedia);
                    if (this.checkMismatchMultimedia(song)) this.multimediaList[iteration] = song;
                }
            }
            case "audiobook" -> {
                AudioBook audioBook = this.multimediaInfoCreator.getAudiobookInfo(multimedia);
                if (this.checkMismatchMultimedia(audioBook)) this.multimediaList[iteration] = audioBook;
            }
            default -> System.out.println("Sorry, nothing was found for your query...");
        }
    }

    public void printMultimediaList() {
        System.out.println("There are results of you search:");
        for (int x = 0; x < this.multimediaList.length; x++) {
            if (this.multimediaList[x] != null) System.out.println(x + 1 + ". " + this.multimediaList[x] + "\n");
        }
    }

}
