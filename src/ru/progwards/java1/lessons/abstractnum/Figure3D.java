package ru.progwards.java1.lessons.abstractnum;

public class Figure3D {
    //конструктор будет сохранять в классе значение длины отрезка. Для куба это будет длина стороны, для шара - радиус
    Number segment;
    public Figure3D(Number segment) {
        this.segment = segment;
    }
    //метод будет возвращать объем фигуры. Для класса Figure3D это будет null
    public Number volume() {
        return null;
    }
}
