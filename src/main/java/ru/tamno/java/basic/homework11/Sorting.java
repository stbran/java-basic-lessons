package ru.tamno.java.basic.homework11;

import java.util.Arrays;

public class Sorting {
    public static int[] sort(int[] array) {
        if (array.length == 0) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j + 1 < array.length && array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }


    /**
     * Быстрая сортировка, также известная как Quick Sort или
     * сортировка Хоара, является одним их самых эффективных алгоритмов.
     * Она включает в себя три этапа:
     * 1. Из массива выбирается опорный элемент, чаще всего
     * посередине массива.
     * 2. Другие элементы массива распределяются таким образом,
     * чтобы меньшие размещались до него, а большие — после.
     * 3. Далее первые шаги рекурсивно применяются к подмассивам,
     * которые разделились опорным элементом на две части — слева
     * и справа от него.
     * Сложность алгоритма: O(n log n)
     */
    public static void quickSort(int[] sortArr, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (sortArr.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = sortArr[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (sortArr[i] < border) i++;
            while (sortArr[j] > border) j--;
            if (i <= j) {
                int swap = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(sortArr, low, j);
        if (high > i) quickSort(sortArr, i, high);
    }

    /**
     * Сортировка слиянием:
     * Данный алгоритм разбивает список на две части,
     * каждую из них он разбивает ещё на две и так далее,
     * пока не останутся единичные элементы. Массив из одного
     * элемента считается упорядоченным. Соседние элементы
     * сравниваются и соединяются вместе. Так происходит до тех пор,
     * пока все элементы не будут отсортированы.
     * Сортировка осуществляется путём сравнения наименьших элементов
     * каждого подмассива. Первые элементы каждого подмассива
     * сравниваются первыми. Наименьший элемент перемещается в
     * результирующий массив. Счётчики результирующего массива и
     * подмассива, откуда был взят элемент, увеличиваются на один.
     * Сложность алгоритма: O(n log n)
     */

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
