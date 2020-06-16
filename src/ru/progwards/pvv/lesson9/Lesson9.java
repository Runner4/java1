package ru.progwards.pvv.lesson9;

import java.math.BigDecimal;

public class Lesson9 {

    class Person {
        public String name;
        public Person(String name) {
            this.name = name;
        }
    }

    abstract class PersonCompare {
        public int compare(Person p1, Person p2) {
            return 0;
        }
    }

    /*Напишите фрагмент кода, в котором создайте переменную класса PersonCompare personCompare
      и проинициализируйте ее анонимным классом, который перекрывает метод compare реализуя его
      через p1.name.compareTo(p2.name)*/

    PersonCompare personCompare = new PersonCompare(){
        @Override
        public int compare(Person p1, Person p2) {
            return p1.name.compareTo(p2.name);
        }
    };

    //Описан класс

    static class Rectangle {

        Rectangle(BigDecimal a, BigDecimal b) {
            this.a = a;
            this.b = b;
        }
        public BigDecimal a;
        public BigDecimal b;
    }

   /* Напишите функцию со спецификацией boolean rectCompare(Rectangle r1, Rectangle r2), которая возвращает true
      если площади прямоугольников равны*/

    static boolean rectCompare(Rectangle r1, Rectangle r2) {
        BigDecimal s1 = r1.a.multiply(r1.b);
        BigDecimal s2 = r2.a.multiply(r2.b);
        return s1.compareTo(s2) == 0;
    }
}
