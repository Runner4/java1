package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        double Pi = 3.14;
        double R = 6371.2;
        return (4.0/3.0)*(Pi)*(R*R*R);
    }
     public static float volumeBallFloat(float radius){
        float Pi = 3.14f;
        float R = 6371.2f;
        return (float) (4.0f/3.0f)*Pi*(R*R*R);
    }
    public static double calculateAccuracy(double radius){
        return volumeBallDouble(radius)-volumeBallFloat((float)radius);
    }
    public static void main(String[] args) {
        //double R = 6371.2;
        //float R = 6371.2f;
        System.out.println(volumeBallDouble(1));
        System.out.println(volumeBallFloat(1));
        System.out.println(calculateAccuracy(1));
    }
}
