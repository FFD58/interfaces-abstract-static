package ru.fafurin.lesson2.task2;

public class WikiPage {

    private PageDownloader pageDownloader = new PageDownloader();
    private String searchLine;

    private String content;

    private final String uri = "https://ru.wikipedia.org/wiki/";

    public WikiPage(String searchLine) {
        this.searchLine = searchLine;
        this.getContentBySearchLine();
    }

    private void getContentBySearchLine() {
        this.content = this.pageDownloader.downloadWebPage(uri + this.searchLine);
    }

    @Override
    public String toString() {
        return "The following was found for your query (" + this.searchLine + ")...\n" + content;
    }
}
