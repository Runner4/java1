package ru.progwards.pvv.lesson14;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Lesson14tests {
    // Что будет выведено на экран в результате выполнения методов:

    //  void dequeueTest() {
    public static void main(String[] args) {

        ArrayDeque deque = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque.offer(i);
            if (i % 2 == 0)
                deque.poll();
        }
        System.out.println(deque);
        // void pqTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
        pQueue.offer(10);
        pQueue.offer(1);
        pQueue.offer(9);
        pQueue.offer(3);
        System.out.println(pQueue);

    }

}
