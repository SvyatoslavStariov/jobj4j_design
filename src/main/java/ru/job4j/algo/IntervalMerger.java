package ru.job4j.algo;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalMerger {

    public int[][] merge(int[][] intervals) {
        int[][] tempArray = new int[intervals.length][];
        int temp = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                tempArray[temp++] = current;
                current = next;
            }
        }
        tempArray[temp++] = current;
        int[][] result = new int[temp][];
        System.arraycopy(tempArray, 0, result, 0, temp);
        return result;
    }
}