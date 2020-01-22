package ru.progwards.pvv.lesson6;

import java.util.Arrays;

public class Lesson6 {
/*
Напишите функцию, суммирующие значения элементов одномерного массива,
 содержащего целые числа. Сигнатура:
public int sumArrayItems(int[] a)
*/
public static int sumArrayItems(int[] a){
    int result = 0;
    for (int value : a)
        result += value;
    return result;
}
/*
Описан класс

	class Rectangle {
		private double a;
		private double b;

		public Rectangle(double a, double b) {
		        this.a = a;
			this.b = b;
                 }

		public double area() {

			return a*b;
		}
}

реализуйте метод compareTo с сигнатурой
public int compareTo(Rectangle anRectangle) который должен сравнивать прямоугольники по величине их площади.
При сравнении a.compareTo(b) метод должен возвращать
a   > b : 1
a == b : 0
a   < b : -1

Например

прямоугольник 2x2  >  прямоугольника 1x1 - результат 1
прямоугольник 2x3 == прямоугольнику 3x2 - результат 0
прямоугольник 2x2  <  прямоугольника 3x3 - результат -1

 */
class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {

        return a*b;
    }
    public int compareTo(Rectangle anRectangle) {
        double s1 = this.area();
        double s2 = anRectangle.area();
        return s1 >= s2 ? (s1 == s2 ? 0 : 1) : -1;
    }
}
/*
Реализуйте функцию, возвращающую максимальный по значению элемент массива. Если в массиве 0 элементов, вернуть 0. Сигнатура функции

public int arrayMax(int[] a)

Подсказка - для быстрой реализации удобно использовать функцию Arrays.sort()
 */
public static int arrayMax(int[] a) {
    Arrays.sort(a);
    return a.length > 0 ? a[a.length - 1] : 0;
}

    public static void main(String[] args) {
        int[] a = {3,2,1};
        System.out.println("" + sumArrayItems(a));
        String str1 = "12345";
        String str2 = "12345";
        System.out.println(str1 == str2);
        System.out.println("" + arrayMax(a));
    }
}
