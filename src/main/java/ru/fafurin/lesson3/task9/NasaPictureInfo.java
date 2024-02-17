package ru.fafurin.lesson3.task9;

public class NasaPictureInfo {
    private String title;
    private String explanation;
    private String date;
    private String url;

    public String getUrl() {
        return url;
    }

    public NasaPictureInfo(String title, String explanation, String date, String url) {
        this.title = title;
        this.explanation = explanation;
        this.date = date;
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nExplanation: %s\nDate: %s\nurl: %s", this.title, this.explanation, this.date, this.url);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NasaPictureInfo info)) return false;
        return this.url.equals(info.url);
    }

}
