package ru.tamno.java.basic.hw13;

public class Main {
    public static void main(String[] args) {
        Human bob = new Human("Bob", null);
        Car hyndai = new Car("Hyndai", 1, 100);
        Car kia = new Car("KIA", 1, 50);
        Human gob = new Human("Gob", kia);
        bob.getIn(hyndai);
        bob.move(10, Location.FOREST);
        bob.move(100, Location.PLAIN);
        bob.getOut(hyndai);
        bob.getIn(kia);
        bob.move(110, Location.PLAIN);
        bob.getOut(kia);
        bob.relax(10);
        bob.move(90, Location.PLAIN);
        gob.move(10, Location.PLAIN);
        Rover rover = new Rover("Луноход", 5, 200);
        bob.getIn(rover);
        bob.move(100, Location.SWAMP);
        bob.move(100, Location.FOREST);
        rover.resuplly(200);
        bob.move(100, Location.FOREST);
        bob.getOut(rover);
        Bicycle bike = new Bicycle("stells", 5, 5);
        bob.relax(10);
        bob.getIn(bike);
        bob.move(5, Location.FOREST);
    }
}
