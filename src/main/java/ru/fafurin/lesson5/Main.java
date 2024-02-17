package ru.fafurin.lesson5;

import ru.fafurin.lesson5.task1.SongLyrics;
import ru.fafurin.lesson5.task2.FileSongLyrics;
import ru.fafurin.lesson5.task3.DirectorySongLyrics;
import ru.fafurin.lesson5.task4.ApiSongLyrics;
import ru.fafurin.lesson5.task4.SongNotFoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

// Урок 5. Абстрактные методы и классы
public class Main {
    public static void main(String[] args) {

// 1. Создайте абстрактный класс SongLyrics, который возвращает текст песни по названию.

// 2. Создайте файл в формате: Название песни: текст песни, и так много песен
// (можете разделять разные песни пустыми строками, или другим способом)
// Создайте наследника - FileSongLyrics, который ищет в файле по названию песни, и если находит, возвращает текст песни
        FileSongLyrics fileSongLyrics = new FileSongLyrics();
        System.out.println(fileSongLyrics.getSongText("Eminem", "Without Me"));

// 3. Создайте наследника - DirectorySongLyrics, который ищет в папке файл с названием песни, и если находит - возвращает текст песни
        DirectorySongLyrics directorySongLyrics = new DirectorySongLyrics();
        System.out.println(directorySongLyrics.getSongText("Eminem", "The Way I Am"));

// 4. Создайте ApiSongLyrics, который ищет текст песни в этом апи:
// https://api.lyrics.ovh/v1/Eminem/Lose%20yourself (откройте в браузере).
// Артиста и название песни можно менять. Вместо пробелов вставляйте %20.
        ApiSongLyrics apiSongLyrics = new ApiSongLyrics();
        System.out.println(apiSongLyrics.getSongText("Eminem", "Rock bottom"));

// 5. Создайте метод printLyrics(String artist, String song, SongLyrics songLyrics) -
// который выводит текст песни. Вызовите этот метод с наследником по выбору пользователя (из файла, папки или апи)
        getSongText();
    }

    private static void getSongText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter an artist name: ");
        String artist = scanner.nextLine();
        System.out.print("Please, enter a song title: ");
        String song = scanner.nextLine();

        System.out.println("How would you like to find a song text?");
        System.out.println("1. From file...");
        System.out.println("2. From directory...");
        System.out.println("3. From API...");
        System.out.print("Please, enter a number: ");
        int number = 1;
        try {
            number = scanner.nextInt();
            switch (number) {
                case 1 -> printLyrics(artist, song, new FileSongLyrics());
                case 2 -> printLyrics(artist, song, new DirectorySongLyrics());
                case 3 -> printLyrics(artist, song, new ApiSongLyrics());
                default -> System.out.println("Wrong number!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Number must be between 1 and 3! Please, rerun program");
        }
    }

    private static void printLyrics(String artist, String song, SongLyrics songLyrics) {
        try {
            String songText = songLyrics.getSongText(artist, song);
            System.out.println("Result of your search:\n");
            System.out.println(songText);
        } catch (SongNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}