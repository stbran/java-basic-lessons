package ru.tamno.java.basic.hw13;

public class Main {
    public static void main(String[] args) {
        Human bob = new Human("Bob", null);
        Car hyndai = new Car("Hyndai", 1, 100);
        Car kia = new Car("KIA", 1, 50);
        Human gob = new Human("Gob", kia);
        bob.getIn(hyndai);
        bob.go(10, Location.FOREST, hyndai);
        bob.go(100, Location.PLAIN, hyndai);
        bob.go(10, Location.FOREST, kia);
        bob.getOut(hyndai);
        bob.getIn(kia);
        bob.go(110, Location.PLAIN, kia);
        bob.getOut(kia);
        bob.setMaxDistance(10);
        bob.go(90, Location.PLAIN, null);
        bob.relax();
        System.out.println(bob.getCurrentTransport());
        gob.go(10, Location.PLAIN, kia);
        System.out.println(gob.getCurrentTransport());
        Rover rover = new Rover("Луноход", 5, 200);
        bob.getIn(rover);
        bob.go(100, Location.SWAMP, rover);
        bob.go(100, Location.FOREST, rover);
        rover.resuplly(200);
        bob.go(100, Location.FOREST, rover);
        bob.getOut(rover);
        Bicycle bike = new Bicycle("stells", 5, 5);
        bob.getIn(bike);
        bob.relax();
        bob.go(5, Location.FOREST, bike);
        bob.go(100, Location.FOREST, bike);

    }
}
