package ru.progwards.java1.lessons.maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов. Методы:
2.1 public static void processFile(String fileName) - загрузить содержимое файла
2.2 public static Map<Character, Integer> getLetters() - вернуть Map, который содержит все найденные
буквы и цифры, и количество раз, которое встретился каждый искомый символ. Знаки препинания,
такие как “.,!? @” и др не учитывать.
2.3 public static Map<String, Integer> getWords() - вернуть Map, который содержит все найденные
слова и количество раз, которое каждое слово встретилось. Знаки препинания, такие как “.,!? @” и др
являются разделителями.
2.4 Протестировать на файле wiki.train.tokens (во вложении), для отладки можно использовать
wiki.test.tokens
*/

public class UsageFrequency {
    public  List<String> lines = new ArrayList<>();
    public  String line;
    public void processFile(String fileName){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));//открываем файл
            try {
                while ((line =  reader.readLine()) != null) {
                    lines.add(line);//читаем построчно

                }
            } finally {
                reader.close();//закрываем
            }

        } catch (Exception e){
        }




    }
    public  Map<Character, Integer> getLetters(){
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i<lines.size(); i++){
            //System.out.println(lines.get(i));
            char[] arrayChar = lines.get(i).toCharArray();//получаем масив из символов
            for (char c : arrayChar){
                if (Character.isDigit(c) || Character.isLetter(c)){
                    if (map.containsKey(c)){
                        map.put(c,map.get(c)+1);
                    } else {
                        map.put(c,1);
                    }
                }

            }
        }
        return map;
    }

    public  Map<String, Integer> getWords(){
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i<lines.size(); i++){
            String[] arrayStr = lines.get(i).trim().split("[^0-9a-zA-Z_]");

            for (String c : arrayStr){
                if(c.trim().length() != 0){
                    if (map2.containsKey(c)){
                        map2.put(c,map2.get(c)+1);
                    } else {
                        map2.put(c,1);
                    }
                }



            }
        }
        return map2;
    }

    public static void main(String[] args) {
//        UsageFrequency.processFile("wiki.test.tokens");
//        //UsageFrequency.processFile("file1.txt");
//        System.out.println(getLetters());
//        System.out.println(getWords());

    }
}