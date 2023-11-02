package ru.tamno.java.basic.hw11;

public class Animal {
    protected String name;
    protected float speedRun;
    protected float speedSwim;
    protected float endurance;
    private float runningEnduranceCost = 1f;
    protected float swimmingEnduranceCost;

    public Animal(String name, float speedRun, float speedSwim, float endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

    public float getRunningEnduranceCost() {
        return runningEnduranceCost;
    }

    public float run(int distance) {
        float timeRun = 0;
        timeRun = distance / speedRun;
        System.out.println("Затрачено " + timeRun + " минут");
        endurance -= distance * runningEnduranceCost;
        if (endurance <= 0) {
            System.out.println("У " + name + " появилось состояние усталости");
            return -1;
        }
        return timeRun;
    }

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

    public void info() {
        System.out.println(name + ": выносливость " + endurance);
    }
}
