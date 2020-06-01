package ru.progwards.java1.lessons.abstractnum;

public class IntNumber extends Number {
    int number;

    public IntNumber(int number) {
        this.number = number;
    }
    @Override
    public Number mul(Number num) {
        String str = num.toString();
        int i = Integer.parseInt(str);
        return new IntNumber(number * i);
    }
    @Override
    public Number div(Number num) {
        String str = num.toString();
        int i = Integer.parseInt(str);
        return new IntNumber(number / i);
    }
    @Override
    public Number newNumber(String strNum) {
        return new IntNumber(Integer.parseInt(strNum));
    }
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
