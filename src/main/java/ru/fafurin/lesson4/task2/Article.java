package ru.fafurin.lesson4.task2;

public class Article {
    private String author;
    private String title;
    private String content;
    private String date;
    private String imageUrl;
    private String readMoreUrl;

    public Article(String author, String title, String content, String date, String imageUrl, String readMoreUrl) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.date = date;
        this.imageUrl = imageUrl;
        this.readMoreUrl = readMoreUrl;
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nAuthor: %s\nDate: %s\nContent: %s\nImage url: %s\nRead more url: %s\n",
                this.title, this.author, this.date, this.content, this.imageUrl, this.readMoreUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return this.readMoreUrl.equals(article.readMoreUrl);
    }

}
