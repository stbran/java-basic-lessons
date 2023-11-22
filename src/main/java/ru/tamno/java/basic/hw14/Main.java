package ru.tamno.java.basic.hw14;


public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"0","0","0","0"},{"0","0","0","0"},{"0","0","0","0"}};
//        String[][] arr = new String[][]{{"0","a","0","0"},{"0","0","0","0"},{"0","0","0","0"},{"0","0","0","0"}};
//        String[][] arr = new String[][]{{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};
        try {
            sumElementsArray(arr);
        } catch (AppArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void sumElementsArray(String arr[][]) throws AppArraySizeException, AppArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new AppArraySizeException("Неверный размер массива");
        }
        int sumElements = 0;
        String regex = "\\d+";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!arr[i][j].matches(regex)) {
                    throw new AppArrayDataException("Error in arr[" + i + "][" + j + "]");
                }
                sumElements += Integer.valueOf(arr[i][j]);
            }
        }
        System.out.println("Сумма элементов массива = " + sumElements);
    }
}
