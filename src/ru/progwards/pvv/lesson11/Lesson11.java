package ru.progwards.pvv.lesson11;

import java.io.IOException;
import java.io.RandomAccessFile;
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
        StringBuilder result = new StringBuilder(); // создаём буфер на 30 символов
        for (int i = splitted.length - 1; i >= 0; i--) {
            result.append(splitted[i]); // переворачиваем массив строк
            if (i>0) result.append("."); // добавляем в качестве разделителя .
        }
        return result.toString();
    }

    /*
    Реализовать метод с сигнатурой public String setStars(String filename)
    который читает файл filename и меняет в нем каждый 10-й байт на символ *,
    при этом конкатенируя оригинальный символ в строку ответа.
    В случае ошибки выбросить исключение IOException со строкой сообщения:равной имени класса оригинального сообщения
    Например,при содержимом файла:
    0123456789012345678A012345678B01
    новое содержимое должно быть
    012345678*012345678*012345678*01
    и метод должен вернуть "9AB"
    */

    static String setStars(String filename) {
        int star = (int)'*';
        StringBuilder result = new StringBuilder(100);
        try(RandomAccessFile raf = new RandomAccessFile(filename,"rw")) {
            long totalBytes = raf.length();
            for(long i = 9; i<totalBytes; i+=10) {
                raf.seek(i);
                result.append((char)raf.readUnsignedByte());
                raf.seek(i);
                raf.writeByte(star);
            }
        } catch (Throwable e) {
            //System.out.println(e.getClass().getName());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(invertWords("Буря мглою небо кроет"));
        System.out.println(setStars("0123456789012345678A012345678B01"));
    }
}
