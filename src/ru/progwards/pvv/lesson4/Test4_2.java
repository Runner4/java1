package ru.progwards.pvv.lesson4;

public class Test4_2 {
    static String textGrade(int grade) {
        if (grade == 0)
            return ("не оценено");
        if (grade >= 1 && grade <= 20)
            return ("очень плохо");
        if (grade >= 21 && grade <= 40)
            return ("плохо");
        if (grade >= 41 && grade <= 60)
            return ("удовлетворительно");
        if (grade >= 61 && grade <= 80)
            return ("хорошо");
        if (grade >= 81 && grade <= 100)
            return ("отлично");
        else
            return "не определено";
    }
     public static void main(String[] args) {

        System.out.println(textGrade(58));
    }
}