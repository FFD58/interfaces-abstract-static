package ru.fafurin.lesson4.task2;

public class NewsParser implements NewsParserContract {
    Article[] articles = new Article[50];
    String data;

    public void parse(String category) {
        this.data = this.getNews(category);
        int x = 0;
        try {
            while (this.data.contains("author")) {
                this.articles[x++] = new Article(
                        this.createFieldByTag("author"),
                        this.createFieldByTag("title"),
                        this.createFieldByTag("content"),
                        this.createFieldByTag("date"),
                        this.createFieldByTag("imageUrl"),
                        this.createFieldByTag("readMoreUrl")
                );
                String replace = this.data.substring(data.indexOf("{"), this.data.indexOf("}") + 2);
                this.data = this.data.replace(replace, "");
            }
        } catch (RuntimeException e) {
            System.out.println("Incorrect input data!");
        }
    }

    private String createFieldByTag(String tag) {
        int currentIndex = this.data.indexOf(tag) + tag.length() + 3;
        return this.data.substring(currentIndex, this.data.indexOf("\"", currentIndex));
    }

    public void printResult() {
        System.out.println("Results of your search:");
        for (int x = 0; x < this.articles.length; x++) {
            if (this.articles[x] != null) System.out.println(x + 1 + ". " + this.articles[x]);
        }
    }
}
