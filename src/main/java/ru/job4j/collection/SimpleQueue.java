package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int sizeIn;
    private int sizeOut;

    public T poll() {
        if (sizeIn == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        while (sizeOut < sizeIn) {
            out.push(in.pop());
            sizeOut++;
        }
        sizeIn = sizeIn - sizeOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}