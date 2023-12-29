package ru.tamno.java.basic.lesson21;

public class FourThreads {
    public static void main(String[] args) throws InterruptedException {
        double[] array = new double[100_000_000];
        long time = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < array.length / 4; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = array.length / 4; i < array.length / 2; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = array.length / 2; i < array.length * 3 / 4; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = array.length * 3 / 4; i < array.length; i++) {
                array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println((System.currentTimeMillis() - time) / 1000 + " сек.");
    }
}
