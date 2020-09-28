package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/*
Кеш для чисел Фибоначчи на Map
1.1 Определить приватную локальную переменную fiboCache как Map<Integer, BigDecimal>
1.2 Определить конструктор public FiboMapCache(boolean cacheOn) - включен ли кэш.
При cacheOn = true кэш работает, при cacheOn = false - выключен
1.3 Реализовать public BigDecimal fiboNumber(int n). Алгоритм работы следующий:
в функции проверить, находится ли вычисленное значение для n в кэше, и
если да - вернуть его из кэша, если нет - рассчитать и добавить в кэш.
Учитывать значение переменной cacheOn
1.4 Реализовать метод public void clearCache() который устанавливает переменную fiboCache в null
1.5 Для проверки работы реализовать public static void test() - тест для расчета чисел Фибоначчи
от n = 1 до 1000 включительно и замерить разницу во времени с on = true и on = false,
результат вывести на экран в формате "fiboNumber cacheOn=??? время выполнения ???"
для cacheOn=true и cacheOn=false, вместо ??? вывести реальные значения в мсек.
*/

public class FiboMapCache {
    private Map<Integer, BigDecimal> fiboCache = new HashMap<>();
    boolean cacheOn;

    public FiboMapCache(boolean cacheOn){
        this.cacheOn = cacheOn;
    }

    public BigDecimal fiboNumber(int n){
        if (cacheOn){
            if (fiboCache.containsKey(n)){
                return fiboCache.get(n);

            } else {
                int i = 1;

                BigDecimal fib1 = BigDecimal.valueOf(0);
                BigDecimal fib2 = BigDecimal.valueOf(1);
                BigDecimal fib = BigDecimal.valueOf(1);

                while (i < n) {

                    fib = fib1.add(fib2);
                    fib1 = fib2;
                    fib2 = fib;
                    i++;
                }
                fiboCache.put(n,fib);
                return fib;
            }
        } else {
            int i = 1;

            BigDecimal fib1 = BigDecimal.valueOf(0);
            BigDecimal fib2 = BigDecimal.valueOf(1);
            BigDecimal fib = BigDecimal.valueOf(1);

            while (i < n) {

                fib = fib1.add(fib2);
                fib1 = fib2;
                fib2 = fib;
                i++;
            }

            return fib;
        }
    }

    public void clearCahe(){
        fiboCache.clear();
    }

    public  void test(){

        long start = System.currentTimeMillis();
        for (int i=1; i<=1000; i++){
            new FiboMapCache(true).fiboNumber(i);
        }
        long rezult1 = System.currentTimeMillis() - start;

        long start2 = System.currentTimeMillis();
        for (int i=1; i<=1000; i++){
            new FiboMapCache(false).fiboNumber(i);
        }
        long rezult2 = System.currentTimeMillis() - start2;
        System.out.println("fiboNumber cacheOn=true время выполнения " + rezult1);
        System.out.println("fiboNumber cacheOn=false время выполнения " + rezult2);
    }

    public static void main(String[] args) {
        FiboMapCache fiboMapCache = new FiboMapCache(true);

        System.out.println(fiboMapCache.fiboNumber(6));
        System.out.println(fiboMapCache.fiboNumber(25));
        System.out.println(fiboMapCache.fiboNumber(6));
        //fiboMapCache.clearCahe();
        System.out.println(fiboMapCache.fiboCache);

        //test();
    }
}