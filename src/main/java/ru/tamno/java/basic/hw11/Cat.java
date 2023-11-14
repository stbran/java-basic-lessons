package ru.tamno.java.basic.hw11;

public class Cat extends Animal {

    public Cat(String name, float speedRun, float speedSwim, float endurance) {
        super(name, speedRun, speedSwim, endurance);
    }

    @Override
    public float swim(int distance) {
        System.out.println("Кошки не умеют плавать");
        return -1;
    }
}
