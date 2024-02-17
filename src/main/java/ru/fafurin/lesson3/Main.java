package ru.fafurin.lesson3;

import ru.fafurin.lesson3.task6.FileInformation;
import ru.fafurin.lesson3.task8.ITunesSearcher;
import ru.fafurin.lesson3.task9.LoaderFromNasaApi;
import ru.fafurin.lesson3.task9.NasaPictureInfoCreator;

import java.time.LocalDate;

// Урок 3. Равенство и equals
public class Main {
    public static void main(String[] args) {

// 1. Поймайте в дебаггере метод String.equals

// Метод String.equals сравнивает эту строку с указанным объектом.
// Результатом является true тогда и только тогда, когда аргумент не равен null и является объектом String,
// представляющим ту же последовательность символов, что и этот объект


// 2. Поймайте в дебаггере метод StringBuilder.equals

//  StringBuilder не переопределяет метод equals класса Object,
//  метод StringBuilder.equals работает так же, как и метод equals класса Object


// 3. Поймайте в дебаггере метод Object.equals

//    public boolean equals(Object obj) {
//        return (this == obj);
//    }

// Для любых ненулевых ссылочных значений x и y этот метод возвращает true тогда и только тогда,
// когда x и y ссылаются на один и тот же объект (x == y имеет значение true).


// 4. В чем разница сравнения через == и через equals?

// Оператор == сравнивает, указывают ли две ссылки на один и тот же объект.
// equals сравнивает значения ссылочных типов данных


// 5. Всегда ли сравнение через equals сравнивает значения элементов?

// Мы можем переопределить метод equals так, как нам необходимо и сравнивать что угодно и как угодно...


// 6. Реализуйте метод equals для класса FileInformation. Покажите, работает?
        FileInformation fileInformation1 = new FileInformation("D:\\Program Files\\Java\\", "Main.java", 34524);
        FileInformation fileInformation2 = new FileInformation("D:\\Program Files\\Java\\", "Main.java", 34524);
        System.out.println(fileInformation1.equals(fileInformation2));

// 7. Реализуйте метод equals для класса ITunesProduct.
// 8. Доработайте медиабраузер iTunes: он будет сохранять все найденные результаты в массив,
// далее давай пользователю возможность поискать еще раз; но скрывая повторяющиеся результаты (сверяясь с массивом)
        ITunesSearcher searcher = new ITunesSearcher();

// 9. Реализуйте метод equals для класса NasaPictureInfo. Как сделать его максимально просто?

// Проще всего сравнивать только по url.

        LoaderFromNasaApi loader = new LoaderFromNasaApi();
        NasaPictureInfoCreator nasaPictureInfoCreator = new NasaPictureInfoCreator();

        nasaPictureInfoCreator.create(loader.returnNASAImagesData(LocalDate.of(2023,5,1), LocalDate.of(2023,5,30)));
        nasaPictureInfoCreator.printResult();
    }
}
