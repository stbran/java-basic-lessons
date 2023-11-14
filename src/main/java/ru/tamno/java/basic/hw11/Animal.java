package ru.tamno.java.basic.hw11;

public abstract class Animal {
    protected String name;
    protected float speedRun;
    protected float speedSwim;
    protected float endurance;
    protected float runningEnduranceCost = 1f;
    protected float swimmingEnduranceCost;

    public Animal(String name, float speedRun, float speedSwim, float endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
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

    public abstract float swim(int distance);

    public void info() {

        System.out.println(name + ": выносливость " + endurance);
    }
}
