package ru.tamno.java.basic.homeworks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = initTwoDimensionalArray();
        System.out.println("Сумма всех положительных элементов массива: " + sumOfPositiveElements(arr));
        System.out.println("\nПечать квадрата:");
        printSquare((int) (Math.random() * 10) + 2);
        System.out.println("Зануление главной диагонали:");
        zeroForMainDiagonal(initTwoDimensionalArray());
        System.out.println("Зануление побочной диагонали:");
        zeroForSecondaryDiagonal(initTwoDimensionalArray());
        System.out.println("Нахождение максимального элемента:");
        System.out.println(findMax(initTwoDimensionalArray()));
        System.out.println("\nНахождение суммы элементов второй строки двумерного массива:");
        System.out.println(sumElementsOfSecondLine(initTwoDimensionalArray()));
        System.out.println("\nНахождение суммы элементов второй строки одномерного массива:");
        System.out.println(sumElementsOfSecondLine(new int[][]{{9, -1, 2}}));
    }

    public static int[][] initTwoDimensionalArray() {
        int size = (int) (Math.random() * 6 + 2);
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * (-10) + 5);
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        return arr;
    }

    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static void printSquare(int size) {
        char[][] arr = new char[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '*';
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void zeroForMainDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    public static void zeroForSecondaryDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1 - i; j >= 0; ) {
                arr[i][j] = 0;
                break;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    public static int findMax(int[][] arr) {
        int maxElement = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > maxElement) {
                    maxElement = arr[i][j];
                }
            }
        }
        return maxElement;
    }

    public static int sumElementsOfSecondLine(int[][] arr) {
        int sum = 0;
        if (arr.length > 1) {
            for (int i = 0; i < arr[1].length; i++) {
                sum += arr[1][i];
            }
            return sum;
        } else return -1;
    }
}