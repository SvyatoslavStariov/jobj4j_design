package ru.job4j.algo;

import java.util.Arrays;

public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

        private static int[] merge(int[] left, int[] right) {
            int[] result = new int[left.length + right.length];
            int indexLeft = 0;
            int indexRight = 0;
            for (int i = 0; i < result.length; i++) {
                if (left.length <= indexLeft) {
                    result[i] = right[indexRight++];
                } else if (right.length <= indexRight) {
                    result[i] = left[indexLeft++];
                } else if (right[indexRight] <= left[indexLeft]) {
                    result[i] = right[indexRight++];
                } else if (left[indexLeft] <= right[indexRight]) {
                    result[i] = left[indexLeft++];
                }
            }
            return result;
        }
}
