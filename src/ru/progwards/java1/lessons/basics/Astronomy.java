package ru.progwards.java1.lessons.basics;

public class Astronomy {
    public static Double sphereSquare(Double r) {
        double Pi = 3.14;
        return 4.0 * Pi * (r * r);
    }

    public static Double earthSquare() {
        double r = 6371.2;
        return sphereSquare(r);
    }

    public static Double mercurySquare() {
        double r = 2439.7;
        return sphereSquare(r);
    }

    public static Double jupiterSquare() {
        double r = 71492.0;
        return sphereSquare(r);
    }

    public static Double earthVsMercury() {
        return earthSquare() / mercurySquare();
    }

    public static Double earthVsJupiter() {
        return earthSquare() / jupiterSquare();
    }

    public static void main(String[] args) {
        System.out.println(sphereSquare(10.5));
        System.out.println(earthSquare());
        System.out.println(mercurySquare());
        System.out.println(jupiterSquare());
        System.out.println(earthVsMercury());
        System.out.println(earthVsJupiter());
    }
}
