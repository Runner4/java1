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
        result += (num >> 7) & 0b00000001;
        result += (num >> 6) & 0b00000001;
        result += (num >> 5) & 0b00000001;
        result += (num >> 4) & 0b00000001;
        result += (num >> 3) & 0b00000001;
        result += (num >> 2) & 0b00000001;
        result += (num >> 1) & 0b00000001;
        result += (num >> 0) & 0b00000001;
        return result;
    }
}