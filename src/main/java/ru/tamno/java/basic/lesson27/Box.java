package ru.tamno.java.basic.lesson27;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> fruits = new ArrayList<>();

    public Box(List<T> fruits) {
        this.fruits = fruits;
    }

    public void put(T fruit) {
        fruits.add(fruit);
    }

    public int weight() {
        int res = 0;
        for (T fruit : fruits) {
            res += fruit.weight;
        }
        return res;
    }

    public boolean compare(Box box) {
        if (this.weight() >= box.weight()) {
            return true;
        }
        return false;
    }

    public void transfer(Box<? super Fruit> box, int countFruits) {
        if (countFruits < 1) {
            return;
        }
        if (fruits.size() < countFruits) {
            System.out.println("Ничего не выйдет(");
            return;
        }
        int thisCount = fruits.size() - 1;
        for (int i = 0; i < countFruits; i++) {
            T fruit = fruits.remove(thisCount - i);
            box.fruits.add(fruit);
        }
    }


}
