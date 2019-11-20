package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        //double Pi = 3.14;
        //double R = radius;
        return (4.0/3.0)*3.14*(radius*radius*radius);
    }
     public static float volumeBallFloat(float radius){
       // float Pi = 3.14f;
        //float R = radius;
        return (float) (4.0/3.0)*3.14f*(radius*radius*radius);
    }
    public static double calculateAccuracy(double radius){
        return volumeBallDouble(radius)-volumeBallFloat((float)radius);
    }
    public static void main(String[] args) {
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat(6371.2f));
        System.out.println(calculateAccuracy(6371.2));
    }
}
