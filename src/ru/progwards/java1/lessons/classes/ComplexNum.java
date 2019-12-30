package ru.progwards.java1.lessons.classes;
/*
Задача 3. Класс ComplexNum
Реализовать класс ComplexNum, реализующий операции в комплексных числах. Напоминаем, что комплексное число
записывается как z = a + bi, где z это комплексное число, a действительная часть, b мнимая часть,
i обозначение мнимой части.
a и b реализуем целыми числами
3.1 конструктор
public ComplexNum(int a, int b), который инициализирует комплексное число
3.2 метод
public String toString(), приведение к строке, выдать в формате a+bi, например, при a=1 и b=56
должно быть выдано 1+56i
3.3 метод
public ComplexNum add(ComplexNum num1, ComplexNum num2), сложение комплексных чисел по формуле:
(a + bi) + (c + di) = (a + c) + (b + d)i
3.4 метод
public ComplexNum sub(ComplexNum num1, ComplexNum num2), вычитание комплексных чисел по формуле:
(a + bi) - (c + di) = (a - c) + (b - d)i
3.5 метод
public ComplexNum mul(ComplexNum num1, ComplexNum num2), умножение комплексных чисел по формуле:
(a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
3.5 метод
public ComplexNum div(ComplexNum num1, ComplexNum num2), деление комплексных чисел по формуле:
(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
*/

public class ComplexNum {
    int a;
    int b;
    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public ComplexNum newComplexNum(int a, int b) {
        return new ComplexNum(a, b);
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }
    public ComplexNum add(ComplexNum num) {
        int a = num.a, b = num.b, c = num.a, d = num.b;
        return new ComplexNum (num.a + num.a, num.b + num.b);
    }
    public ComplexNum sub(ComplexNum num) {
        int a = num.a, b = num.b, c = num.a, d = num.b;
        return new ComplexNum(num.a - num.a, num.b - num.b);
    }
    public ComplexNum mul(ComplexNum num) {
        int a = num.a, b = num.b, c = num.a, d = num.b;
        return new ComplexNum(a * c - b * d, b * c + a * d);
    }
    public ComplexNum div(ComplexNum num) {
        int a = num.a, b = num.b, c = num.a, d = num.b;
        return new ComplexNum((a * c + b * d) / (c * c + d * d),
                (b * c - a * d) / (c * c + d * d));
    }
    public static void main(String[] args) {
        ComplexNum a = new ComplexNum(2, 2);
        ComplexNum b = new ComplexNum(1, 1);
//        System.out.println(a.add(a, b));
//        System.out.println(a.sub(a, b));
//        System.out.println(a.mul(a, b));
//        System.out.println(a.div(a, b));
    }
}