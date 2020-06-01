package ru.progwards.java1.lessons.abstractnum;

public class Test {
    public static void main(String[] args) {
        Number num = new IntNumber(3);
        Figure3D fig = new Cube(num);

        System.out.println(fig.volume());
    }
}
