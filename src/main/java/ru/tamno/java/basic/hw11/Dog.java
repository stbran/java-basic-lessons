package ru.tamno.java.basic.hw11;

public class Dog extends Animal {
    public Dog(String name, float speedRun, float speedSwim, float endurance) {
        super(name, speedRun, speedSwim, endurance);
        this.swimmingEnduranceCost = 2;
    }

    @Override
    public float swim(int distance) {
        float timeSwim = 0;
        timeSwim = distance / speedSwim;
        System.out.println("Затрачено " + timeSwim + " минут");
        endurance -= distance * swimmingEnduranceCost;
        if (endurance <= 0) {
            System.out.println("У " + name + " появилось состояние усталости");
            return -1;
        }
        return timeSwim;
    }
}
