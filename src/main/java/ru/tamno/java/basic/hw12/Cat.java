package ru.tamno.java.basic.hw12;

public class Cat {
    final String name;
    final int appetite;
    private boolean satiety; //сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        if (plate.minusEat(appetite)) {
            satiety = true;
            System.out.println("Кот " + this.name + " наелся");
        } else {
            System.out.println("Кот " + this.name + " остался голоден");
        }
    }
}

