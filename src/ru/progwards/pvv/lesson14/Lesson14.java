package ru.progwards.pvv.lesson14;

import java.util.ArrayDeque;

public class Lesson14 {
    //Создайте метод с сигнатурой ArrayDeque<Integer> array2queue(int[] a),
    // который копирует содержимое массива в очередь

    ArrayDeque<Integer> array2queue(int[] a) {
        ArrayDeque<Integer> result = new ArrayDeque<Integer>();
        if (a == null) return result;
        for (int e : a) {
            result.offer(e);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Lesson14().array2queue(new int[]{4, 2, 1}));
//        int a[] = {1, 19, 22, 13};
//        ArrayDeque<Integer> deque = array2queue(a);
//        int res = sumLastAndFirst(deque);
    }

    //Реализуйте метод с сигнатурой int sumLastAndFirst(ArrayDeque<Integer> deque) который возвращает сумму первого и
    // последнего элемента очереди. При пустой очереди вернуть 0

    int sumLastAndFirst(ArrayDeque<Integer> deque) {
        if (deque.isEmpty()) return 0;
        return deque.peekFirst() + deque.peekLast();
    }

}
