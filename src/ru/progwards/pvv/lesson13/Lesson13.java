package ru.progwards.pvv.lesson13;

import java.util.*;

public class Lesson13 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 2, 3, 0, 111};
        System.out.println(Arrays.toString(a));
        Set<Integer> s = new Lesson13().a2set(a);
        //for(int i:s) System.out.println(i);
        System.out.println(new Lesson13().a2set(a));
    }

    //Определены классы

    //Реализуйте метод,с сигнатурой public Set<Integer> a2set(int[] a), который преобразует массив в множество
    public Set<Integer> a2set(int[] a) {
        Set<Integer> result = new HashSet<>();
        for (int i : a) result.add(i);
        return result;
    }

    String figDetect(Figure fig) {
        if (fig == null) return "Неизвестная фигура";
        if (fig.getClass() == Square.class) return "Сторона квадрата " + ((Square) fig).getSide();
        if (fig.getClass() == Round.class) return "Диаметр круга " + ((Round) fig).getDiameter();
        return "Неизвестная фигура";
    }

    public TreeSet<User> createSet() {
        TreeSet<User> result = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.id, o1.id);
            }
        });
        return result;
//        Test
//        TreeSet<User> backsort = createSet();
//        backsort.add(new User(11, "Маша"));
//        backsort.add(new User(15, "Саша"));
//        backsort.add(new User(23, "Соня"));
//        backsort.add(new User(44, "Даша"));
    }

    /*Напишите метод с сигнатурой String figDetect(Figure fig), который
     - для квадрата возвращает "Сторона квадрата "+.side
     - для круга возвращает "Диаметр круга "+.diameter
     - для всех остальных классов "Неизвестная фигура"*/

    class Figure {

    }

    class Square extends Figure {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getSide() {
            return side;
        }
    }

    class Round extends Figure {
        private double diameter;

        public Round(double diameter) {
            this.diameter = diameter;
        }

        public double getDiameter() {
            return diameter;
        }
    }

    /*Определен класс
        class User {
            public Integer id;
            public String name;
            User (Integer id, String name) {
                this.id = id;
                this.name = name;
            }
        }
        Создайте метод с сигнатурой public TreeSet<User> createSet() который
        создает и возвращает TreeSet так, что бы пользователи оказались упорядочены по убыванию id
    */
    class User {
        public Integer id;
        public String name;

        User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
