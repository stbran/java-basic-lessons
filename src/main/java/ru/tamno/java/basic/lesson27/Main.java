package ru.tamno.java.basic.lesson27;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Apple apple1 = new Apple(1);
        Apple apple2 = new Apple(2);
        Apple apple3 = new Apple(2);
        Orange orange1 = new Orange(3);
        Orange orange2 = new Orange(4);
        Orange orange3 = new Orange(4);

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple1);
        fruits.add(orange1);

        List<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);

        List<Orange> oranges = new ArrayList<>();
        oranges.add(orange1);
        oranges.add(orange2);

        Box<Fruit> fruitBox = new Box<>(fruits);
        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);

        fruitBox.put(apple2);
        fruitBox.put(orange2);
        appleBox.put(apple3);
        orangeBox.put(orange3);

        System.out.println("fruits: " + fruitBox.weight());
        System.out.println("apples: " + appleBox.weight());
        System.out.println("oranges: " + orangeBox.weight());

        System.out.println(fruitBox.compare(appleBox));
        System.out.println(fruitBox.compare(orangeBox));

        appleBox.transfer(fruitBox, 3);
        orangeBox.transfer(fruitBox, 2);
        fruitBox.transfer(fruitBox, 1);
    }
}
