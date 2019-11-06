package ru.progwards.java1.lessons.helloworld;

public class Task1 {
    //1.1 Реализовать функцию public static void main(String[] args) в которой следует: создать три строковые переменные со значениями:
    //
    //        "Хорошо идут дела"
    //        "Изучаю Java я!"
    //        " "
    //
    //вывести на консоль, используя только эти переменные и функции System.out.print(), System.out.println() следующий текст:
    //Хорошо идут дела
    //Изучаю Java я!
    //Хорошо идут дела Изучаю Java я!
    //Изучаю Java я! Хорошо идут дела
    static void Task1() {
        String x;
        String y;
        String z;
        x = "Хорошо идут дела";
        y = "Изучаю Java я!";
        z = " ";
        System.out.println(x);
        System.out.println(y);
        System.out.print(x);
        System.out.print(z);
        System.out.println(y);
        System.out.print(y);
        System.out.print(z);
        System.out.println(x);
    }
    public static void main(String[] args) {
        Task1();
    }
}