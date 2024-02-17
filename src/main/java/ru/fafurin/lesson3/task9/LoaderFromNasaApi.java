package ru.fafurin.lesson3.task9;

import done.four.lesson7.PageDownloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoaderFromNasaApi {
    // uri NASA API astronomy picture of the day

    private final PageDownloader pageDownloader = new PageDownloader();
    private static final String NASA_API = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";


    // Возвращает explanation сегодняшнего снимка дня NASA
    public String returnTodayExplanation() {
        String result = this.pageDownloader.downloadWebPage(NASA_API);
        int explanationIndex = result.indexOf("explanation") + "explanation".length() + 3;
        return result.substring(explanationIndex, result.indexOf("\"", explanationIndex));
    }

    // Возвращает explanation снимка дня NASA по дате
    public String returnExplanationByDate(LocalDate date) {
        String dateStr = this.dateToString(date);
        String dates = String.format("&start_date=%s&end_date=%s", dateStr, dateStr);
        String result = this.pageDownloader.downloadWebPage(NASA_API + dates);
        int explanationIndex = result.indexOf("explanation") + "explanation".length() + 3;
        return result.substring(explanationIndex, result.indexOf("\"", explanationIndex));
    }

    // Возвращает данные по снимкам дней NASA в интервале из двух дат
    public String returnNASAImagesData(LocalDate startDate, LocalDate endDate) {
        String startDateStr = this.dateToString(startDate);
        String endDateStr = this.dateToString(endDate);
        String dates = String.format("&start_date=%s&end_date=%s", startDateStr, endDateStr);
        String url = NASA_API + dates;
        return this.pageDownloader.downloadWebPage(url);
    }

    public void getFileFromString(String string) {
        boolean isExit = true;

        System.out.println(string);

        while (isExit) {
            // проверяем есть ли в строке url
            if (string.contains("\"url\"")) {
                // получаем ссылку на изображение
                String url = string.substring(string.indexOf("\"url\"") + 7, string.indexOf("}") - 1);

                System.out.println(url);

                System.exit(1);

                // из ссылки получаем название файла
                String filename = url.substring(url.lastIndexOf("/") + 1);
                // создаем папку в директории проекта
                String path = System.getProperty("user.dir") + "\\images";
                try {
                    Files.createDirectories(Paths.get(path));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                // проверяем картинку ли мы закачиваем
                if (filename.contains("jpg")) {
                    try (InputStream in = new URL(url).openStream()) {
                        Files.copy(in, Paths.get("images/" + filename));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Image " + filename + " saved.");
                // удаляем из строки блок с загруженной картинкой
                String replace = string.substring(string.indexOf("{"), string.indexOf("}") + 2);
                string = string.replace(replace, "");

            } else isExit = false;
        }
        System.out.println("Images downloaded...");
    }

    private String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }
}
