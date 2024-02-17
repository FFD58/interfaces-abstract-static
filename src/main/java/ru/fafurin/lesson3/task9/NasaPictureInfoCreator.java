package ru.fafurin.lesson3.task9;

import utils.PageDownloader;

import java.util.Scanner;

public class NasaPictureInfoCreator {
    private PageDownloader downloader = new PageDownloader();
    private Scanner scanner = new Scanner(System.in);
    private String source;
    private NasaPictureInfo[] infoList = new NasaPictureInfo[50];

    private String createFieldByTag(String tag) {
        int currentIndex = source.indexOf(tag) + tag.length() + 3;
        return source.substring(currentIndex, source.indexOf("\"", currentIndex));
    }

    public void create(String source) {
        this.source = source;
        int x = 0;
        try {
            while (source.contains("explanation")) {
                this.infoList[x++] = new NasaPictureInfo(
                        this.createFieldByTag("title"),
                        this.createFieldByTag("explanation"),
                        this.createFieldByTag("date"),
                        this.createFieldByTag("url")
                );
                String replace = this.source.substring(source.indexOf("{"), this.source.indexOf("}") + 2);
                this.source = this.source.replace(replace, "");
            }
        } catch (RuntimeException e) {
            System.out.println("Incorrect input data!");
        }
    }

    private void saveImages() {
        System.out.println("Do you want to save this picture?");
        System.out.println("Please, enter yes or no...");
        if (this.scanner.next().equals("yes")) {
            this.downloadImages();
        } else System.out.println("Have a nice day!");
    }

    private void downloadImages() {
        for (int x = 0; x < this.infoList.length; x++) {
            if (this.infoList[x] != null) this.downloader.downloadFileFromUrl(this.infoList[x].getUrl());
        }
    }

    public void printResult() {
        System.out.println("Result of your search:");
        for (int x = 0; x < this.infoList.length; x++) {
            if (this.infoList[x] != null) System.out.println(x + 1 + ". " + this.infoList[x]);
        }
        this.saveImages();
    }
}
