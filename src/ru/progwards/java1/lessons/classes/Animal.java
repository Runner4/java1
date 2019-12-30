package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;
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
        return getFoodCoeff() * 0.02;
    }
    public double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }
    //@Override
    public String toString() {
        return "I am " + getKind() + ", eat " + getFoodKind();
    }
   // @Override
    public String toStringFull() {
        return super.toString() + " " + calculateFoodWeight();
    }
}