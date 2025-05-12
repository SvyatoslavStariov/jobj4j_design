package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    /**
     * Вычислительная сложность: O(n)
     * Пространственная сложность: O(1), т.к. выделение памяти не зависит от количества элементов в 'nums'
     */
    public static int[] findSmallestRange(int[] nums, int k) {
        int differentElementCount = 0;
        int[] result = null;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length || nums[i] < nums[i + 1]) {
                differentElementCount++;
            }
            if (differentElementCount == k) {
                result = new int[] {i - differentElementCount + 1, i};
                break;
            } else if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                differentElementCount = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
