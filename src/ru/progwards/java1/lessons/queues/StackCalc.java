package ru.progwards.java1.lessons.queues;

//        Стековый калькулятор (есть даже такой стековый язык программирования - Forth). Стек, это структура данных,
//        работающая по принципу LIFO - last in first out (последний вошедший выходит первый),
//        это противоположность привычной очереди FIFO - first in first out - первый вошедший выходит первый
//        Реализовать class StackCalc, который содержит стек чисел с плавающей точкой (double).
//        Выбрать наиболее удобную для этого коллекцию. Реализовать методы работы со стеком:
//        3.1 public void push(double value) - положить value на вершину стека
//        3.2 public double pop() - взять (убрать) значение с вершины стека
//        3.3 public void add() - сложить 2 верхних значения на стеке, результат положить на стек.
//        В итогу в стеке должно быть на один элемент меньше
//        3.4 public void sub() - вычесть верхнее значение на стеке, из следующего по глубине, результат положить на стек.
//        В итоге в стеке должно быть на один элемент меньше
//        3.5 public void mul() - умножить 2 верхних значения на стеке, результат положить на стек.
//        В итогу в стеке должно быть на один элемент меньше
//        3.6 public void div() - поделить на верхнее значение на стеке, следующее по глубине, результат положить на стек.
//        В итоге в стеке должно быть на один элемент меньше

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public  class StackCalc {
    public static ArrayDeque<Double> arrayDeque = new ArrayDeque();
    // положить value на вершину стека

    public void push(double value){
        arrayDeque.offerLast(value);
    }

//взять (убрать) значение с вершины стека

    public double pop(){
        return  arrayDeque.pollLast();
    }


    //сложить 2 верхних значения на стеке, результат положить на стек. В итогу в стеке должно быть на один элемент меньше
    public static void add(){
        arrayDeque.offerLast(arrayDeque.pollLast() + arrayDeque.pollLast());

    }
    //вычесть верхнее значение на стеке, из следующего по глубине, результат положить на стек. В итоге в стеке должно быть на один элемент меньше

    public static void sub(){
        double dobEnd = arrayDeque.pollLast();
        arrayDeque.offerLast( arrayDeque.pollLast() - dobEnd);
    }
    // умножить 2 верхних значения на стеке, результат положить на стек. В итогу в стеке должно быть на один элемент меньше
    public static void mul(){
        arrayDeque.offerLast(arrayDeque.pollLast() * arrayDeque.pollLast());
    }
    //
    //    // поделить на верхнее значение на стеке, следующее по глубине, результат положить на стек. В итоге в стеке должно быть на один элемент меньше
    public static void div(){
        double dobEnd = arrayDeque.pollLast();
        arrayDeque.offerLast( arrayDeque.pollLast() / dobEnd);
    }
    @Override
    public String toString() {
        return "StackCalc{" +
                "arrayDeque=" + arrayDeque +
                '}';
    }

    public static void main(String[] args) {
        StackCalc stackCalc = new StackCalc();
        Collection<Double> collection = new LinkedList<>(List.of(25.3,36.2,48.5,85.5,145.0,25.0));
        stackCalc.arrayDeque.addAll(collection);

        System.out.println(stackCalc);
        //stackCalc.add();
        //stackCalc.sub();
        //stackCalc.mul();
        stackCalc.div();
        System.out.println(stackCalc);
    }
}