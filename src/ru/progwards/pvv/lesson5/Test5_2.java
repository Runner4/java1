package ru.progwards.pvv.lesson5;

public class Test5_2 {
    /*
    Создайте класс Calculator, содержащий
    приватную переменную int result;
    конструктор по умолчанию, устанавливающий result = 0;
    публичную функцию set(int num), устанавливающую значение result равный num
    публичную функцию add(int num), увеличивающую result на num
    публичную функцию sub(int num), уменьшающую result на num
    публичную функцию int getResult()
    */
    public static class Calculator {
        private int result;

        public Calculator() {
            result = 0;
        }

        public int set(int num) {
            return result = num;
        }

        public int add(int num) {
            return result += num;
        }

        public int sub(int num) {
            return result -= num;
        }

        public int getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.getResult());
        c.set(5);
        c.add(4);
        c.sub(11);
        System.out.println(c.getResult());

    }
}
