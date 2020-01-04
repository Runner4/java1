package ru.progwards.java1.lessons.classes;
/* Задача 1. Классы Animal, Cow, Hamster, Duck
Реализовать класс Animal, содержащий:
1.0 Реализовать конструктор
public Animal(double weight), который сохраняет вес животного.
1.1 Метод:
public AnimalKind getKind(), который возвращает вид животного (enum AnimalKind - ANIMAL, COW, HAMSTER, DUCK). В данном классе вернуть ANIMAL
1.2 Метод
public FoodKind getFoodKind(), который возвращает вид еды, (enum FoodKind - UNKNOWN, HAY, CORN). В данном классе вернуть UNKNOWN
1.3 Метод
public String toString(), который возвращает информацию о животном в формате:
I am <AnimalKind>, eat <FoodKind>

Реализовать класс Cow, потомок класса Animal, переопределяющий методы:
1.4 public AnimalKind getKind(), который возвращает COW.
1.5 public FoodKind getFoodKind(), который возвращает HAY

Реализовать класс Hamster, потомок класса Animal, переопределяющий методы:
1.6  public AnimalKind getKind(), который возвращает HAMSTER.
1.7 public FoodKind getFoodKind(), который возвращает CORN

Реализовать класс Duck, потомок класса Animal, переопределяющий методы:
1.8 public AnimalKind getKind(), который возвращает DUCK.
1.9 public FoodKind getFoodKind(), который возвращает CORN

Задача 2. метод calculateFoodWeight

2.1 В классе Animal реализовать метод:
public double getWeight(), который возвращает вес животного
2.2 Реализовать метод
public double getFoodCoeff(), который возвращает коэффициент веса еды к весу тела животного. Для класса Animal это 0.02

2.3 Для класса Cow, переопределить метод:
public double getFoodCoeff(), который должен возвращать 0.05

2.4 Для класса Hamster, переопределить метод:
public double getFoodCoeff(), который должен возвращать 0.03

2.5 Для класса Duck, переопределить метод:
public double getFoodCoeff(), который должен возвращать 0.04

2.6 Для класса Animal, реализовать метод:
public double calculateFoodWeight(), который рассчитывает необходимый вес еды, по формуле - вес-еды = вес-животного * коэффициент веса тела.

2.7 Для класса Animal, создать метод
public String toStringFull(), что бы он возвращал информацию о животном в формате:
I am <AnimalKind>, eat <FoodKind> <CalculateFoodWeight> */

public class Animal {
    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    enum FoodKind {
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