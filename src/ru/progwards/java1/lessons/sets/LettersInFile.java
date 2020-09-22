package ru.progwards.java1.lessons.sets;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.TreeSet;

//        Реализовать класс, считывающий содержимое файла и возвращающего набор букв,
//        которые встречались в этом файле. Буквы, это латинские [A..Z[ и [a..z] и русские [А..Я] и [а..я],
//        остальные символы надо игнорировать
//        3.1 Метод public static String process(String fileName) - вернуть все буквы,
//        которые встретились в файле, сконкатенированные в виде строки.
//        Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
//        Все возникающие исключения, по работе с потоками, пробросить выше.

public class LettersInFile {
    public static String process(String fileName) throws IOException {
        String ret = "";    //  пустая строка для результата
        TreeSet<Character> set1 = new TreeSet<>();  // множество для символов с автоматической сортировкой
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            String currentLine = raf.readLine();
            if (currentLine != null){
                currentLine = new String(currentLine.getBytes("ISO-8859-1"), "UTF-8");
            }
            char[] alphabet = currentLine.toCharArray();    //  строку в массив символов
            for (char letter : alphabet)                    //  цикл по массиву символов
                if (Character.isLetter(letter))             //  проверить, что это буква
                    if (! set1.contains(letter))            //  проверить наличие в множестве
                        set1.add(letter);   //  добавить символ в коллекцию если такой отсутствует
            Character[] array = set1.toArray(new Character[0]);
            for (Character letter : array)
                ret += letter + "";

        } catch (Exception e) {
            throw e;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(process("C:\\Users\\Владислав\\IdeaProjects\\HelloWorld\\src\\ru\\progwards\\java1\\lessons\\sets\\file1.txt"));
//        System.out.println(process(null));
    }
}