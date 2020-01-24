package ru.progwards.java1.lessons.arrays;
/*
Реализовать динамический, саморастущий массив целых чисел, по следующей спецификации:

3.1 в классе разместить private переменную - массив целых чисел.
3.2 конструктор - по умолчанию.
3.2 метод
public void add(int num) - добавляет элемент num в конец массива, при этом размер массива должен увеличиться на 1.
Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый, и добавить в хвост элемент num.
3.3 метод
public void atInsert(int pos, int num) - добавляет элемент num в позицию pos массива,
при этом размер массива должен увеличиться на 1.
Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый,
c учетом того, что новый элемент окажется где-то в середине, и потом положить в нужный индекс элемент num.
3.4 метод
public void atDelete(int pos) - удаляет элемент в позиции pos массива, при этом размер массива должен уменьшиться на 1.
Для этого нужно будет разместить новый массив нужного размера, скопировать в него старый,
уже без элемента, который был в позиции pos.
3.5 метод
public int at(int pos) - возвращает элемент по индексу pos.
*/

import java.util.Arrays;

public class DIntArray {
    private int[] numbers = {};

    DIntArray() {};

    public void add(int num) {
        int[] numbers1 = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, numbers1, 0, numbers.length);
        numbers1[numbers.length] = num;
        numbers = numbers1;
    }

    public void atInsert(int pos, int num) {
        int[] numbers1 = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, numbers1, 0, pos);
        System.arraycopy(numbers, pos, numbers1, pos + 1, numbers.length - pos);
        numbers1[pos] = num;
        numbers = numbers1;
    }

    public void atDelete(int pos) {
        int[] nums1 = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, nums1, 0, pos);
        System.arraycopy(numbers, pos + 1, nums1, pos, numbers.length - pos - 1);
        numbers = nums1;
    }

    public int at(int pos) {
        return numbers[pos];
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
    public void print() {
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        DIntArray a = new DIntArray();
        a.print();
        a.add(1); a.add(2); a.add(4); a.add(5);
        a.print();
        a.atInsert(2, 3);
        a.print();
        a.atDelete(1);
        a.print();
    }
}
