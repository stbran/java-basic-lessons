package ru.tamno.java.basic.hw11;

public class Horse extends Animal {
    public Horse(String name, float speedRun, float speedSwim, float endurance) {
        super(name, speedRun, speedSwim, endurance);
        this.swimmingEnduranceCost = 4;
    }
}
