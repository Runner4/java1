package ru.progwards.java1.ru.lessons.basics;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        final double Pi = 3.14;
        double R = 6371.2;
        return 4/3*Pi*(R*R*R);
    }
     public static float volumeBallFloat(float radius){
        final float Pi = 3.14f;
        float R = 6371.2f;
        return 4/3*Pi*(R*R*R);
    }
    public static double calculateAccuracy(double radius){
        return volumeBallDouble(radius)-volumeBallFloat((float)radius);
    }
    public static void main(String[] args) {
        System.out.println(volumeBallDouble(1));
        System.out.println(volumeBallFloat(1));
        System.out.println(calculateAccuracy(1));
    }
}
