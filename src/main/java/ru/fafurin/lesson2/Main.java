package ru.fafurin.lesson2;

import ru.fafurin.lesson2.task1.FileInformation;
import ru.fafurin.lesson2.task2.WikiPage;
import ru.fafurin.lesson2.task6.ITunesSearcher;

import java.io.File;
import java.util.Scanner;

// Урок 2. Метод toString
public class Main {
    public static void main(String[] args) {

// 1. У класса FileInformation из предыдущих уроков сделайте метод toString, возвращающий информацию по всем полям.
        File file = new File("4.json");
        FileInformation fileInformation = new FileInformation(file.getAbsolutePath(), file.getName(), 123);
        System.out.println(fileInformation);

// 2. Реализуйте класс, отображающий страничку в википедии.
// Пусть метод toString у него возвращает текст этой странички. Покажите его использование неявно, так:
// WikiPage wikiPage = new WikiPage(“Java”);
// System.out.println(wikiPage);
        WikiPage wikiPage = new WikiPage("Java");
        System.out.println(wikiPage);

//3. Поймайте в дебаггере метод toString у класса String

//   Метод toString у класса String, так как уже является строкой, возвращает текущий объект класса

        //    public String toString() {
        //        return this;
        //    }

//4. Поймайте в дебаггере метод toString у класса Object

// Метод toString у класса Object возвращает строку,
// содержащую название класса (getClass().getName()) и шестнадцатеричное представление 32-битного целого числа (hashCode),
// разделенные символом @

        //     public String toString() {
        //        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        //    }


//5. Поймайте в дебаггере метод toString у класса StringBuilder

// Метод toString у класса StringBuilder возвращает новый объект класса String,
// с переданным в конструктор текущим объектом StringBuilder

        //    @Override
        //    @IntrinsicCandidate
        //    public String toString() {
        //        return new String(this);
        //    }

//6. Сделайте метод toString у класса ITunesSong, который возвращает информацию в формате xml: <artist>Rick Ross</artist>… и так далее
//7. Сделайте метод toString у класса ITunesSong, который возвращает информацию в формате JSON

        //  Метод toString() класса Song возвращает информацию в формате xml
        //  Метод toString() класса Movie возвращает информацию в формате JSON

        ITunesSearcher searcher = new ITunesSearcher(new Scanner(System.in), new StringParser());
        searcher.printMultimediaInfo();
    }
}
