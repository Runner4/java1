package ru.progwards.pvv.lesson10;

import java.io.*;
import java.util.Scanner;

public class Lesson10 {

    public static Integer sqr(Integer n) {
        try {
            return n * n;
        } catch (NullPointerException e) {
            return -1;
        }
    }

    public static String test (String filename) throws IOException {
        //который проверяет filename и если он равен null выбрасывает IOException со строкой "File not found",
        //в противном случает возвращает строку "File processing"
        if (filename == null) throw new IOException("File not found");
        //try {
        java.io.FileWriter f = new java.io.FileWriter(filename, false);
        f.close();
        /*}
        catch (IOException e) {
            return e.toString();
        }*/
        return "File processing";
    }

    /* T3.3
    Реализовать метод с сигнатурой private int lineCount(String filename)
    который возвращает количество строк в файле filename. В случае ошибки
    пробросить исключение IOException со строкой сообщения "файл не найден"
    */

    private int lineCount(String filename) throws IOException {
        int result = 0;
        try{
            FileReader f = new FileReader(filename);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String str = s.nextLine();
                result++;
            }
            s.close();
            f.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
