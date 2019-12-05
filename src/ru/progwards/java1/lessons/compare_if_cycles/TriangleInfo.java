package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c){
        return (a + b > c && a + c > b && b + c > a);
    }
    public static boolean isRightTriangle(int a, int b, int c){
       return  ((a * a) + (b * b) == (c * c) || (a * a) + (c * c) == (b * b) || (b * b) + (c * c) == (a * a));
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        return (a == b || a == c || b == c);
    }
    public static void main(String[] args) {
        System.out.println(isTriangle(15,11,5));
        System.out.println(isRightTriangle(3, 5, 4));
        System.out.println(isIsoscelesTriangle(10,11, 11));
    }
}
