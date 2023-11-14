package ru.tamno.java.basic.hw11;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Pushok", 10, 0, 50);
        cat.swim(1);
        cat.run(40);
        cat.info();
        cat.run(20);
        cat.info();
        Dog dog = new Dog("Sharik", 10, 10, 70);
        dog.swim(5);
        dog.run(40);
        dog.info();
        dog.run(20);
        dog.info();
        Horse horse = new Horse("Hidalgo", 40, 10, 100);
        horse.swim(5);
        horse.run(40);
        horse.info();
        horse.run(40);
        horse.info();
    }
}
