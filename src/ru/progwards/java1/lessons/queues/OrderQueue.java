package ru.progwards.java1.lessons.queues;

//        Создать класс OrderQueue
//        2.7 Создать метод, public void add(Order order), размещающий заказы в очередь с приоритетом,
//        разбивая их по 3-м классам
//        3 - заказы до 10000 руб включительно
//        2 - заказы от 10000 до 20000 руб включительно
//        1 - заказы от 20000 руб
//        2.8 Создать метод, public Order get(), возвращающий первый заказ в очереди для обслуживания.
//        Вначале обслуживаются заказы класса 1, потом 2, потом 3.
//        Внутри каждого класса заказы должны обслуживаться в порядке поступления (по номеру заказа).
//        Метод не выбрасывает исключения, возвращает null в случае пустой очереди.
//        Продумать, и, при необходимости, добавить в классы нужные методы и свойства, для того, чтобы реализовать эту задачу.

import java.util.*;

public class OrderQueue {

    public static PriorityQueue<Order> orderQueue = new PriorityQueue<>();
    public  static  LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

    public static void add(Order order){

        orderQueue.offer(order);
        linkedHashSet.add(order.getNum()+1);


    }
    public static Order get(){

        return orderQueue.poll();

    }

    public static void main(String[] args) {

        Order order = new Order(57000);
        Order order1 = new Order(6580);
        Order order2 = new Order(18800);
        Order order3 = new Order(19600);
        Order order4 = new Order(200);
        Order order5 = new Order(6500);
        Order order6 = new Order(18000);
        Order order7 = new Order(9000);

//        System.out.println(order.getNum());
//        System.out.println(order1.getNum());
        add(order);
        add(order1);
        add(order2);
        add(order3);
        add(order4);
        add(order5);
        add(order6);
        add(order7);

        while (!orderQueue.isEmpty()) {
            System.out.println(get());
        }
    }
}