package ru.progwards.pvv.lesson10;

public class Lesson10 {

    public static Integer sqr(Integer n) {
        try {
            return n * n;
        } catch (NullPointerException e) {
            return -1;
        }
    }
}
