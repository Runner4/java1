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
public ComplexNum add(ComplexNum num), сложение комплексных чисел по формуле:
(a + bi) + (c + di) = (a + c) + (b + d)i
3.4 метод
public ComplexNum sub(ComplexNum num), вычитание комплексных чисел по формуле:
(a + bi) - (c + di) = (a - c) + (b - d)i
3.5 метод
public ComplexNum mul(ComplexNum num), умножение комплексных чисел по формуле:
(a + bi) * (c + di) = (a*c - b*d) + (b*c + a*d)i
3.5 метод
public ComplexNum div(ComplexNum num), деление комплексных чисел по формуле:
(a + bi) / (c + di) = (a*c + b*d)/(c*c+d*d) + ((b*c - a*d)/(c*c+d*d))i
*/

public class ComplexNum {
    int a;
    int b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    public ComplexNum add(ComplexNum num) {
        return new ComplexNum(a + num.a, b + num.b);
    }

    public ComplexNum sub(ComplexNum num) {
        return new ComplexNum(a - num.a, b - num.b);
    }

    public ComplexNum mul(ComplexNum num) {
        return new ComplexNum((a * num.a) - (b * num.b), (b * num.a) + (a * num.b));
    }

    public ComplexNum div(ComplexNum num) {
        return new ComplexNum(((a * num.a) + (b * num.b)) / ((num.a * num.a) + (num.b * num.b)),
                ((b * num.a) - (a * num.b)) / ((num.a * num.a) + (num.b * num.b)));
    }

    public static void main(String[] args) {
        ComplexNum c1 = new ComplexNum(1, 2);
        ComplexNum c2 = new ComplexNum(3, 4);
        System.out.println(c1.add(c2));
        System.out.println(c1.sub(c2));
        System.out.println(c1.mul(c2));
        System.out.println(c1.div(c2));
    }

}