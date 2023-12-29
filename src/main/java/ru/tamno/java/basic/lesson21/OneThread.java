package ru.tamno.java.basic.lesson21;

public class OneThread {
    public static void main(String[] args) {
        double[] array = new double[100_000_000];
        long time = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println((System.currentTimeMillis() - time) / 1000 + " сек.");
    }
}
