package ru.progwards.java1.lessons.bitsworld;

/*
3.1 Реализовать конструктор
public Binary(byte num)
3.2 реализовать метод
public String toString(),
который возвращает двоичное представление числа типа byte используя только битовые операции.
В выводимом значении всегда должно быть 8 символов
Например:
0: "00000000"
1: "00000001"
127: "01111111"
-128: "10000000"
-1: "11111111"

*/

public class Binary {

    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 8; i++)
            result += (num >> i) & 0b00000001;

        return num + ":" + " " + result;
    }

    public static void main(String[] args) {
        Binary binary = new Binary((byte) 0);
        Binary binary1 = new Binary((byte) 1);
        Binary binary2 = new Binary((byte) 127);
        Binary binary3 = new Binary((byte) -128);
        Binary binary4 = new Binary((byte) -1);
        System.out.println(binary);
        System.out.println(binary1);
        System.out.println(binary2);
        System.out.println(binary3);
        System.out.println(binary4);
    }
}