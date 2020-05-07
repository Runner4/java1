package ru.progwards.java1.lessons.interfaces;

/*
Задача 1. Классы Animal, Cow, Hamster, Duck
1.1 Для класса Animal из задач 1 и 2, домашнего задания к уроку 5 реализовать метод:
public boolean equals(Object anObject), который возвращает true, если объекты равны и false если не равны по параметру
- вес животного. Убедится, что при равном весе, утка все равно не равна хомяку. Обратите внимание на тип принимаемого
параметра и подумайте над тем, что будет делать ваша программа, если в качестве параметра будет передан объект не
являющийся экземпляром Animal.

Для класса Animal реализовать интерфейс FoodCompare, который сравнивает животных по цене потребляемой еды.
public interface FoodCompare {
    public int compareFoodPrice();
}

Для этого
1.2 В класс Animal добавить метод
public double getFood1kgPrice(), который возвращает информацию о цене 1 кг еды.
метод реализовать в виде switch по FoodKind со следующими значениями
HAY : 20
CORN: 50
UNKNOWN: 0

1.3 В класс Animal добавить метод
public double getFoodPrice(), который возвращает информацию о цене еды для данного животного по формуле
calculateFoodWeight() * getFood1kgPrice()

1.4 В отдельном файле объявить interface FoodCompare
interface FoodCompare {
    public int compareFoodPrice(Animal animal);
}

1.5 В класс Animal реализовать
public int compareFoodPrice(Animal animal), который возвращает результаты сравнения цены еды для данного животного
с ценой еды для другого животного, используя Double.compare;
 */

public class Animal implements FoodCompare {

    static enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    static enum FoodKind {
        UNKNOWN,
        HAY,
        CORN
    }

    double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return 0.02;
    }

    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }

    @Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }

    public String toStringFull() {
        return toString() + " " + calculateFoodWeight();
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject == this) return true;
        if (anObject == null || anObject.getClass() != this.getClass()) return false;
        Animal o = (Animal) anObject;
        return Double.compare(o.calculateFoodWeight(), this.calculateFoodWeight()) == 0;
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY:
                return 20;
            case CORN:
                return 50;
        }
        return 0;
    }

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }

    @Override
    public int compareFoodPrice(Animal animal) {
        return Double.compare(getFoodPrice(), animal.getFoodPrice());
    }

    public static void main(String[] args) {
        Animal animal = new Animal(0);
        Cow cow = new Cow(350);
        Hamster hamster = new Hamster(0.1);
        Duck duck = new Duck(4);
        System.out.println(animal.toStringFull());
        System.out.println(cow.toStringFull());
        System.out.println(hamster.toStringFull());
        System.out.println(duck.toStringFull());
    }
}
