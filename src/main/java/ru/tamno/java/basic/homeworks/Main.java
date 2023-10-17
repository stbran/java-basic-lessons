package ru.tamno.java.basic.homeworks;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //init array
        int[] arr = initArray();

        //application methods
        copyString((int) (Math.random() * 10), "I'am copyString");
        sumElementsArrayMore5(arr);
        fillArray((int) (Math.random() * 100), new int[20]);
        addNumberToElementsArray((int) (Math.random() * 100), arr);
        whichHalfArrayIsBigger(arr);

        // application methods (*)
        sumArrays(new int[]{1}, new int[]{4, 5}, new int[]{7, 8, 9});
        findEqualPoint(new int[]{1, 1, 1, 1, 1, 5});
        findEqualPoint(new int[]{5, 3, 4, -2});
        findEqualPoint(new int[]{7, 2, 2, 2});
        findEqualPoint(new int[]{9, 4});
        System.out.println("Отсортирован ли массив по возрастанию: " + isArraySortAsc(new int[]{1, 2, 3, 4, 5, 6}) + "\n");
        System.out.println("Отсортирован ли массив по убыванию: " + isArraySortDesc(new int[]{1, 0, -1, -2, -5, -6}) + "\n");
        System.out.println(Arrays.toString(reverseArray(new int[]{7, 6, 3, 2})));
    }
    public static int[] initArray() {
        int[] arr = new int[(int) (Math.random() * 20) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        System.out.println("Создание массива: " + Arrays.toString(arr));
        System.out.println();
        return arr;
    }

    public static void copyString(int count, String str) {
        System.out.println(count + " раз \"" + str + "\":");
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
        System.out.println();
    }

    public static void sumElementsArrayMore5(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("Сумма всех элементов массива, значение которых больше 5 = " + sum);
        System.out.println();
    }

    public static void fillArray(int element, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = element;
        }
        System.out.println("Заполнили массив элементом " + element + "\n" + Arrays.toString(arr));
        System.out.println();
    }

    public static void addNumberToElementsArray(int number, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += number;
        }
        System.out.println("Увеличили каждый элемент массива на " + number + ":\n" + Arrays.toString(arr));
        System.out.println();
    }

    public static void whichHalfArrayIsBigger(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sum1 += arr[i];
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            sum2 += arr[i];
        }
        if (sum1 > sum2) System.out.println("Сумма элементов первой половины массива больше");
        else if (sum1 < sum2) System.out.println("Сумма элементов второй половины массива больше");
        else System.out.println("Сумма элементов обеих половин массива равна");
        System.out.println();
    }

    public static void sumArrays(int[]... arrs) {
        int maxLength = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i].length > maxLength) {
                maxLength = arrs[i].length;
            }
        }
        int[] sumArrays = new int[maxLength];
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(Arrays.toString(arrs[i]));
            if (arrs[i].length < maxLength) {
                arrs[i] = Arrays.copyOf(arrs[i], maxLength);
            }
        }
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                sumArrays[i] += arrs[j][i];
            }
        }
        System.out.println("Сумма массивов равна " + Arrays.toString(sumArrays));
        System.out.println();
    }

    public static void findEqualPoint(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (sumArrayElements(arr, 0, i) == sumArrayElements(arr, i, arr.length)) {
                System.out.println("Точка равновесия массива " + Arrays.toString(arr) + " находится между " + (i - 1) + " и " + i + " элементами\n");
                return;
            }
        }
        System.out.println("Точка равновесия массива " + Arrays.toString(arr) + " отсутствует\n");
    }

    public static int sumArrayElements(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static boolean isArraySortAsc(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int[] arrSort = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrSort);
        return Arrays.equals(arr, arrSort);
    }

    public static boolean isArraySortDesc(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int[] arrSort = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrSort);
        arrSort = reverseArray(arrSort);
        return Arrays.equals(arr, arrSort);
    }

    public static int[] reverseArray(int[] arr) {
//        System.out.println("Реверс массива" + Arrays.toString(arr));
        int[] arrReverse = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            arrReverse[j] = arr[i];
            j++;
        }
        return arrReverse;
    }
}