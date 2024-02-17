package ru.fafurin.lesson4.task2;

public interface NewsParserContract {
    default String getNews(String cat) {
        PageDownloader pageDownloader = new PageDownloader();
        final String url = "https://inshortsapi.vercel.app/news?category=" + cat;
        return pageDownloader.downloadWebPage(url);
    }
}
