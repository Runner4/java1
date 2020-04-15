package ru.progwards.pvv.lesson3;

public class Test3_1 {
    static int addAsStrings(int n1, int n2) {
        int a = Integer.parseInt(Integer.toString(n1) + Integer.toString(n2));
        return a;
    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(73, 93));
    }
}
