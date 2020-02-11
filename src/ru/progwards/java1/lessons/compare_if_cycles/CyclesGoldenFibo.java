package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    public static boolean containsDigit(int number, int digit) {
        if (number == 0 && digit == 0) return true;
        int n = number;
        while (n > 0) {
            if (n % 10 == digit) return true;
            n /= 10;
        }
        return false;
    }

    public static int fiboNumber(int n) {
        int f1 = 0;
        int f2 = 1;
        int t;
        int i = 1;
        while (i++ < n) {
            t = f2;
            f2 += f1;
            f1 = t;
        }
        return f2;
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {
        float k = 0;
        if (a == b) k = (float)a / c;
        else if (b == c) k = (float)b / a;
        else if (a == c) k = (float)a / b;
        return k > 1.61703f && k < 1.61903f;
    }

    public static void main(String[] args) {
        System.out.println("12345 contains 2: " + containsDigit(12345, 2));

        System.out.println("Fibonacci:");
        for (int i = 1; i <= 15; i++)
            System.out.print(fiboNumber(i) + " ");

        System.out.println("\nGolden triangles:");

        for (int a = 1; a <= 100; a++)
            for (int b = 1; b <= 100; b++)
                if (isGoldenTriangle(a, a, b))
                    System.out.println("( " + a + ", " + a + ", " + b + " )");
    }
}