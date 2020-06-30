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
}
