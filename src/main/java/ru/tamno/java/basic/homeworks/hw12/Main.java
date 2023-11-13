package ru.tamno.java.basic.hw12;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{new Cat("Barsik", 10),
                new Cat("Murzik", 5),
                new Cat("Pushok", 15)};
        Plate plate = new Plate(20);
        cats[0].eat(plate);
        System.out.println("В тарелке осталось " + plate.getCurrentCountEat() + " еды");
        cats[1].eat(plate);
        System.out.println("В тарелке осталось " + plate.getCurrentCountEat() + " еды");
        cats[2].eat(plate);
        System.out.println("В тарелке осталось " + plate.getCurrentCountEat() + " еды");
        plate.addEat(30);
        plate.addEat(10);
        cats[2].eat(plate);
    }
}
