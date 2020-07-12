package ru.progwards.java1.lessons.io2;

public class PhoneNumber {

/*
Создать статический метод public static String format(String phone),
который форматирует телефон под формат +7(999)111-2233, входящий формат может быть различным:
            - 79991112233
            - 8(999)111-22-33
            - 8 999 111 22 33
формальное задание на форматирование:
            - выделить все цифры, отбросить все разделители
- проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
- убрать спереди 8
            - добавить, если нужно +7
            - отформатировать под выходной шаблон*/

    public static String format(String phone) {
        String numbers = phone.replaceAll("[^\\d]", "");
        int numdig = numbers.length();
        if(numdig < 10 || numdig > 11) {
            throw new RuntimeException("В номере телефона должно быть 10 или 11 цифр!");
        }
        return "+" + (numbers.charAt(0)=='8' ? "7" : numbers.substring(0,1))
                + "(" + numbers.substring(1,4) + ")"
                + numbers.substring(4,7) + "-" + numbers.substring(7);
    }

    public static void main(String[] args) {
        System.out.println(format("79991112233"));
        System.out.println(format("8(999)111-22-33"));
        System.out.println(format("8 999 111 22 33"));
        System.out.println(format("8 999 111 22"));
    }
}
