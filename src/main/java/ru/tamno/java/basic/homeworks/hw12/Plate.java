package ru.tamno.java.basic.hw12;

public class Plate {
    final int maxCountEat;
    private int currentCountEat;

    public Plate(int maxCountEat) {
        this.maxCountEat = maxCountEat;
        this.currentCountEat = maxCountEat;
    }

    public int getMaxCountEat() {
        return maxCountEat;
    }

    public int getCurrentCountEat() {
        return currentCountEat;
    }

    public void addEat(int countEat) {
        if (countEat + currentCountEat <= maxCountEat) {
            this.currentCountEat += countEat;
            System.out.println("Запасы пополнились. В тарелке " + this.currentCountEat + " еды");
        } else {
            System.out.println("Объем еды превышен");
        }
    }

    public boolean minusEat(int countEat) {
        if (currentCountEat - countEat >= 0) {
            this.currentCountEat -= countEat;
            return true;
        } else {
            return false;
        }
    }
}

