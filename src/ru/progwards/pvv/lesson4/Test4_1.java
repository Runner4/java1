package ru.progwards.pvv.lesson4;

public class Test4_1 {
    public class Person {
        private String name;
        private int age;
        private String country;
        public Person(){
            country = "RU";
        }
        public Person (String name, int age){
            this();
            this.name = name;
            this.age = age;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public String getCountry(){
            return country;
        }
    }
   // public static void main(String[] args) {

    //}
}
