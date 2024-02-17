package ru.fafurin.lesson4;

import ru.fafurin.lesson4.task2.NewsParser;

// Урок 4. default-методы в интерфейсах
public class Main {
    public static void main(String[] args) {
// 1. Зачем могут пригодиться default-методы в интерфейсах?
        // Ответ: default-методы в интерфейсах могут пригодится в случае,
        // если во всех классах, расширяющих данный интерфейс будет одинаковая реализация методов


//2. Сделайте интерфейс, default-метод которого будет принимать категорию (String cat) -
// который будет запрашивать новости по апи, пример https://inshortsapi.vercel.app/news?category=science (смотреть в браузере)
//3. Список категорий:
// all
// national //Indian News only
// business
// sports
// world
// politics
// technology
// startup
// entertainment
// miscellaneous
// hatke
// science
// automobile
        NewsParser newsParser = new NewsParser();
        newsParser.parse("business");
        newsParser.printResult();
    }
}
