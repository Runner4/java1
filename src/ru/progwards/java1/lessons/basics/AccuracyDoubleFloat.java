package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
  //  public static double volumeBallDouble(double radius){
        //double Pi = 3.14;
        //double R = radius;
    //    return (4.0/3.0)*3.14*(radius*radius*radius);
    //}
     //public static float volumeBallFloat(float radius){
       // float Pi = 3.14f;
        //float R = radius;
       // return (float) (4.0/3.0)*3.14f*(radius*radius*radius);
    //}
    //public static double calculateAccuracy(double radius){
      //  return volumeBallDouble(radius)-volumeBallFloat((float)radius);
    //}
    //public static void main(String[] args) {
      //  System.out.println(volumeBallDouble(6371.2));
        //System.out.println(volumeBallFloat(6371.2f));
        //System.out.println(calculateAccuracy(6371.2));
    //}
  final static double pi = 3.14;
    //final static double earthR = 6_371.2;

    public static double volumeBallDouble(double radius) {
        return pi * radius * radius * radius * 4 / 3;
    }

    public static float volumeBallFloat(float radius) {
        return (float)pi * radius * radius * radius * 4 / 3;
    }

    public static double calculateAccuracy(double radius) {
        return volumeBallDouble(radius) - volumeBallFloat((float)radius);
    }

    public static void main(String[] args) {
       // System.out.println("Volume of R=1(d): " + volumeBallDouble(1));
        //System.out.println("Volume of R=1(f): " + volumeBallFloat(1));
        System.out.println(volumeBallDouble(6371.2));
        System.out.println(volumeBallFloat((float)6371.2));
        System.out.println(calculateAccuracy(6371.2));
    }
}
