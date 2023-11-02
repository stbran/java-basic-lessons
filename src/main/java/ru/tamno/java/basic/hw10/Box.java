package ru.tamno.java.basic.hw10;

import java.util.Arrays;

public class Box {
    private float length;
    private float width;
    private String color;
    private boolean isOpen;
    private int capacity = 5;
    private String[] items = new String[capacity];
    private int countItemsIn = 0;

    public Box(float length, float width, String color, boolean isOpen) {
        this.length = length;
        this.width = width;
        this.color = color;
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) { //true -> открыть коробку, false -> закрыть коробку
        isOpen = open;
    }

    public float getlength() {
        return length;
    }

    public float getwidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) { //метод перекрашивания
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCountItemsIn() {
        return countItemsIn;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public void info() {
        String statusBox;
        if (isOpen) {
            statusBox = "Открытая";
        } else {
            statusBox = "Закрытая";

        }
        System.out.println(statusBox + " коробка, размеры ШхД " + width + "x" + length + ", цвет " + color);
    }


    public void printItems() {
        System.out.println(Arrays.toString(items));
    }

    public void putItem(String... arrItems) {
        if (isOpen) {
            if (countItemsIn < capacity) {
                System.out.print("В коробку положили ");
                for (int i = 0; i < arrItems.length; i++) {
                    if (i < items.length) {
                        System.out.print(arrItems[i] + ", ");
                        items[countItemsIn++] = arrItems[i];
                    } else {
                        System.out.print(arrItems[i] + " не влазит");
                    }
                }
            }
            if (capacity == countItemsIn) {
                System.out.println("\nКоробка полная");
            }
        } else {
            System.out.println("Ничего нельзя положить. Коробка закрыта");
        }
    }


    public void takeOutItem(String... arrItems) {
        if (isOpen) {
            if (countItemsIn > 0) {
                for (int i = 0; i < arrItems.length; i++) {
                    for (int j = 0; j < items.length; j++) {
                        if (arrItems[i].equals(items[j])) {
                            items[j] = null;
                            countItemsIn--;
                            System.out.println("Из коробки достали " + arrItems[i]);
                            break;
                        } else if (j == items.length - 1) {
                            System.out.println(arrItems[i] + " - такого предмета не нашлось");
                        }
                    }
                }
            }
            if (countItemsIn == 0) {
                System.out.println("Коробка пустая");
            }
        } else {
            System.out.println("Ничего нельзя достать. Коробка закрыта");
        }
    }
}
