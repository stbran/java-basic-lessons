package ru.tamno.java.basic.lesson30;

import java.util.List;

public class ReturnArray {
    public int getLastIndexByOne(List<Integer> arr) {
        if (arr.contains(1)) {
            int lastIndex = arr.size() - 1;
            for (int i = lastIndex; i >= 0; i--) {
                if (arr.get(i) == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public List<Integer> returnSubArray(List<Integer> arr) {
        int lastIndex = getLastIndexByOne(arr);
        if (lastIndex >= 0) {
            return arr.subList(lastIndex + 1, arr.size());
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isContainOneOrTwo(List<Integer> arr) {
        if (!(arr.contains(1) && arr.contains(2))) {
            return false;
        }
        for (Integer elem : arr) {
            if (elem != 1 && elem != 2) {
                return false;
            }
        }
        return true;
    }
}
