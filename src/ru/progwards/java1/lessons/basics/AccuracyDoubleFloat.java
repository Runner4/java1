package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public static double volumeBallDouble(double radius) {
        double pi = 3.14;
        return 4.0 / 3.0 * pi * radius * radius * radius;
    }

    public static float volumeBallFloat(float radius) {
        float pi = 3.14f;
        return 4.0f / 3.0f * pi * radius * radius * radius;
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float) radius);
    }

    public static void main(String[] args) {
        System.out.println(volumeBallDouble(1));
        System.out.println(volumeBallFloat(1));
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat(6371.2f));
        System.out.println(calculateAccuracy(6371.2));
    }
}
