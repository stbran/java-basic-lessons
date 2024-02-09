package ru.tamno.java.basic.lesson28;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static char currentLetter = 'C';
    static final Object mon = new Object();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            for (int i = 0; i < 5; i++) {
                printA();
                printB();
                printC();
            }
        });
        executorService.shutdown();
    }

    static void printA() {
        synchronized (mon) {
            try {
                while (currentLetter != 'C') {
                    mon.wait();
                }
                currentLetter = 'A';
                System.out.print(currentLetter);
                mon.notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void printB() {
        synchronized (mon) {
            try {
                while (currentLetter != 'A') {
                    mon.wait();
                }
                currentLetter = 'B';
                System.out.print(currentLetter);
                mon.notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static void printC() {
        synchronized (mon) {
            try {
                while (currentLetter != 'B') {
                    mon.wait();
                }
                currentLetter = 'C';
                System.out.print(currentLetter);
                mon.notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
