package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c){
        if (a>b && a>c)
            return a;
        if (b>a && b>c)
            return b;
        else
            return c;
    }
    public static int minSide(int a, int b, int c){
        if (a<b && a<c)
            return a;
        if (b<a && b<c)
            return b;
        else
            return c;
    }
    public static boolean isEquilateralTriangle(int a, int b, int c){
        return (a == b & a == c & b == c);
    }
    public static void main(String[] args) {
        System.out.println(maxSide(266,587,113));
        System.out.println(minSide(56,34,18));
        System.out.println(isEquilateralTriangle(84,84,84));
    }
}
