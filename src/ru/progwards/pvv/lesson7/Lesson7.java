package ru.progwards.pvv.lesson7;

import java.util.Objects;

public class Lesson7 {
    /*
переопределите метод equals с сигнатурой
public boolean equals(Object anObject) который должен сравнивать прямоугольники по величине их площади.
Например
прямоугольник 2x2 != прямоугольнику 1x1
прямоугольник 2x3 == прямоугольнику 3x2
    */
    class Rectangle {
        private double a;
        private double b;

        public Rectangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double area() {

            return a*b;
        }

        public boolean equals(Object anObject) {

            if(this == anObject) return true;
            if(anObject == null || getClass() != anObject.getClass()) return false;
            Rectangle o = (Rectangle)anObject;
            return Double.compare(area(), o.area()) == 0;
        }
    }
}

