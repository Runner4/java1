package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

     /*
      Реализовать класс BigAlgebra, содержащий следующие статические методы:
      1.1 Метод BigDecimal fastPow(BigDecimal num, int pow)
      Реализовать алгоритм быстрого возведения в степень pow числа num в BigDecimal,
      описание алгоритма можно прочитать например в Википедии
     */

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow) {   //num число, pow степень

        BigDecimal p = BigDecimal.ONE;

        while (pow != 0) {
            if (pow % 2 == 0) {
                pow = pow / 2;
                num = num.multiply(num);
            } else {
                pow--;
                p = num.multiply(p);
            }
        }
        return p;
    }

     /*
      1.2 Метод BigInteger fibonacci(int n)
      Реализовать алгоритм вычисления n-го числа фибоначчи в BigInteger. Последовательность чисел Фибоначчи,
      это когда каждое последующее число равно сумме двух предыдущих чисел. Первые 2 числа последовательности 1, 1.
      Итого получаем 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 и т.д.
     */

    static BigInteger fibonacci(int n) {
        if (n == 1 || n == 0) {
            return BigInteger.ONE;
        }
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(0);
        BigInteger fibo = BigInteger.valueOf(0);

        for (int i = 0; i < n; i++) {
            fibo = a.add(b);
            a = b;
            b = fibo;
        }
        return fibo;
    }

    public static void main(String[] args) {
        System.out.println(fastPow(BigDecimal.valueOf(940), 95));
    }
}
