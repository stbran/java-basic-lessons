package ru.tamno.java.basic.hw11;

public class Dog extends Animal {
    public Dog(String name, float speedRun, float speedSwim, float endurance) {
        super(name, speedRun, speedSwim, endurance);
        this.swimmingEnduranceCost = 2;
    }
}
