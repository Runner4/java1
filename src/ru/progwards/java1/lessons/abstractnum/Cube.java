package ru.progwards.java1.lessons.abstractnum;

public class Cube extends Figure3D {

    public Cube (Number segment) {
        super(segment);
    }

    public Number volume () {
        return segment.mul(segment.mul(segment));
    }
}
