package ru.tamno.java.basic.homeworks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5");
        int choise = sc.nextInt();
        while (true) {
            if (choise == 1) {
                greetings();
                break;
            } else if (choise == 2) {
                int a = (int) (Math.random() * (-51));
                int b = (int) (Math.random() * 51);
                int c = (int) (Math.random() * 31);
                checkSign(a, b, c);
                break;
            } else if (choise == 3) {
                selectColor();
                break;
            } else if (choise == 4) {
                compareNumbers();
                break;
            } else if (choise == 5) {
                int a = (int) (Math.random() * (-51));
                int b = (int) (Math.random() * 51);
                addOrSubtractAndPrint(a, b, true);
                break;
            } else System.out.println("Попробуйте еще раз");
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void selectColor() {
        int data = (int) (Math.random() * 51);
        if (data <= 10) System.out.println("Красный");
        else if (data <= 20) System.out.println("Желтый");
        else System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = (int) (Math.random() * 51);
        int b = (int) (Math.random() * 51);
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else System.out.println(initValue - delta);
    }
}