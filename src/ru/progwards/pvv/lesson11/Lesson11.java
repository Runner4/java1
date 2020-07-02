package ru.progwards.pvv.lesson11;

import java.io.IOException;
import java.util.Scanner;

public class Lesson11 {
    /*
    Существует метод public void doSomething(int n) throws IOException,
    создайте свой метод, с сигнатурой public void test(int n), который должен содержать блоки try-catch-finally
    1) В блоке try вызовите метод doSomething(n)

    2) В блоке catch выведите на консоль строку, полученную из исключения через  getMessage()

    3) Пробросите исключение дальше

    4) В блоке finally выведите на консоль фиксированный текст "finally executed"
    */

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

    /*
    Создайте метод с сигнатурой public void scanLines(), который реализует следующий алгоритм:
    - вводить с клавиатуры строки, до тех пор, пока во входной строке не встретится "/stop"
    - если во входной строке содержится "Привет" вывести на консоль "Здравствуйте!"
    - если во входной строке содержится "как дела" вывести на консоль "Хорошо"
    - если во входной строке содержится "/stop" - закончить выполнение метода
    - во всех остальных случая вывести введенную строку на консоль
    Примечание: для проверки, содержит ли строка, содержимое другой строки используйте метод класса
    String boolean contains(String str)
    */

    public void scanLines() {
        try(Scanner scanner = new Scanner(System.in)) {
            String line, lineLow;
            while (true) {
                line = scanner.nextLine();
                lineLow = line.toLowerCase();
                if (lineLow.contains("привет")) System.out.println("Здравствуйте!");
                else if (lineLow.contains("как дела")) System.out.println("Хорошо");
                else if (lineLow.contains("/stop")) return;
                else System.out.println(line);
            }
        }
    }

    /*
    Реализуйте метод с сигнатурой public String invertWords(String sentence),
    который переставляет слова, в полученной фразе. В качестве исходного
    разделителя использовать пробел. В качестве соединительного точку.
    Например,
    invertWords("Буря мглою небо кроет") должен вернуть
    "кроет.небо.мглою.Буря"
    */

    public static String invertWords(String sentence) {
        String[] splitted = sentence.split(" "); // разбиваем строку на массив строк, разделитель пробел
        StringBuilder result = new StringBuilder(30); // создаём буфер на 30 символов
        for (int i = splitted.length - 1; i >= 0; i--) {
            result.append(splitted[i]); // переворачиваем массив строк
            if (i>0) result.append("."); // добавляем в качестве разделителя .
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(invertWords("Буря мглою небо кроет"));
    }
}
