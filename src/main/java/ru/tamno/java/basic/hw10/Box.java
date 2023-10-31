package ru.tamno.java.basic.hw10;

public class Box {
    private float lengthBox;
    private float widthBox;
    private String color;
    private boolean isOpen;

    public Box(float lengthBox, float widthBox, String color, boolean isOpen) {
        this.lengthBox = lengthBox;
        this.widthBox = widthBox;
        this.color = color;
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) { //true -> открыть коробку, false -> закрыть коробку
        isOpen = open;
    }

    public float getLengthBox() {
        return lengthBox;
    }

    public float getWidthBox() {
        return widthBox;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) { //метод перекрашивания
        this.color = color;
    }

    public void info() {
        String statusBox;
        if (isOpen) {
            statusBox = "Открытая";
        } else {
            statusBox = "Закрытая";

        }
        System.out.println(statusBox + " коробка, размеры ШхД " + widthBox + "x" + lengthBox + ", цвет " + color);
    }

    public void putItem(String item) {
        if (isOpen) {
            System.out.println("В коробке лежит " + item);
        } else {
            System.out.println("Ничего нельзя положить. Коробка закрыта");
        }
    }
}
