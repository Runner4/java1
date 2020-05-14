package ru.progwards.java1.lessons.interfaces;

/*public class CalculateFibonacci {
    private static CacheInfo lastFibo = new CacheInfo();

    public static int fiboNumber(int n) {
        if (lastFibo.n == n) return lastFibo.fibo;
        int f1 = 0;
        int f2 = 1;
        int t;
        int i = 1;
        while (i++ < n) {
            t = f2;
            f2 += f1;
            f1 = t;
        }
        lastFibo.n = n;
        lastFibo.fibo = f2;
        return f2;
    }

    public static class CacheInfo {
        public int n;
        public int fibo;

        CacheInfo() {
            n = -1;
        }

        CacheInfo(int n, int fibo) {
            this.n = n;
            this.fibo = fibo;
        }
    }

    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(29));
    }
}*/
public class CalculateFibonacci {
    private static CacheInfo lastFibo = new CacheInfo();
    public static int fiboNumber(int n) {
        lastFibo = new CacheInfo();
        if (lastFibo.n == n) {
            return lastFibo.fibo;
        }
        int a = 1;
        int b = 0;
        for (int i = 0; i < n; i++) {
            CacheInfo.fibo = a + b;
            a = b;
            b = CacheInfo.fibo;
        }
        System.out.println(CacheInfo.fibo);
        CalculateFibonacci.lastFibo.n = n;
        return CacheInfo.fibo;
    }
    public static class CacheInfo {
        public static int n;
        public static int fibo;
    }
    public static CacheInfo getLastFibo() {
        return lastFibo;
    }
    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static void main(String[] args) {
        fiboNumber(29);
        System.out.println(CacheInfo.fibo);
        System.out.println(CacheInfo.n);
    }
}
