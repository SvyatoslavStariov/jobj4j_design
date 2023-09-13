package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int i = column;
        int j = row;
        while (i < data.length) {
            if (data[i].length == 1) {
                j = 0;
                return true;
            } else if (data[i].length - 1 >= j) {
                j++;
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (column < data.length) {
            if (data[column].length == 1) {
                row = 0;
                return data[column++][row];
            } else if (data[column].length - 1 >= row) {
                return data[column][row++];
            } else {
                column++;
            }
        }
        return 0;
    }
}