package ru.progwards.pvv.lesson11;

import java.io.IOException;

public class Lesson11 {
    /*Существует метод public void doSomething(int n) throws IOException,
    создайте свой метод, с сигнатурой public void test(int n), который должен содержать блоки try-catch-finally
    1) В блоке try вызовите метод doSomething(n)

    2) В блоке catch выведите на консоль строку, полученную из исключения через  getMessage()

    3) Пробросите исключение дальше

    4) В блоке finally выведите на консоль фиксированный текст "finally executed" */

    public static void doSomething(int n) throws IOException {
        throw new IOException("ok");
    }

    public void test(int n) throws IOException {
        try {
            doSomething(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("finally executed");
        }
    }
}
