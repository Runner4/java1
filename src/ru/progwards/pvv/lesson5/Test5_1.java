package ru.progwards.pvv.lesson5;

public class Test5_1 {
    /*
    Создайте класс Person, содержащий:

    приватную переменную String name;
    приватную переменную int age;
    приватную переменную String country;
    конструктор по умолчанию, устанавливающий country = "RU";
    конструктор с параметрами String name, int age, вызывающий конструктор по умолчанию, и устанавливающий значения переменным name и age из соответствующих параметров;
    публичные функции String getName(), int getAge(), String getCountry(), возвращающие значения соответствующих переменных
     */
    public static class Person {
         public String name;
         public int age;
         public String country;

        public Person() {
            country = "RU";
        }

        public Person(String name, int age) {
            this();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCountry() {
            return country;
        }
    }

    public static void main(String[] args) {
        Person p = new Person("Vladimir", 21);
        System.out.println(p.getAge());
        System.out.println(p.getName());
        System.out.println(p.getCountry());

    }
}
