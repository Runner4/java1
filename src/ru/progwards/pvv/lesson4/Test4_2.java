package ru.progwards.pvv.lesson4;

public class Test4_2 {
//    Создайте класс Calculator, содержащий
//    приватную переменную int result;
//    конструктор по умолчанию, устанавливающий result = 0;
//    публичную функцию set(int num), устанавливающую значение result равный num
//    публичную функцию add(int num), увеличивающую result на num
//    публичную функцию sub(int num), уменьшающую result на num
//    публичную функцию int getResult()
public class Calculator {
    private int result;
    public Calculator(){
        result = 0;
    }
    public int set(int num){
        return result = num;
    }
    public int add(int num){
        return result += num;
    }
    public int sub(int num){
        return result -= num;
    }
    public int getResult(){
        return result;
    }
}

    public static void main(String[] args) {

    }
}
