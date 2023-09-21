package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int sizeIn;
    int sizeOut;

    public T poll() {
        if (sizeIn == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        while (sizeOut < sizeIn) {
            out.push(in.pop());
            sizeOut++;
        }
        T t = out.pop();
        sizeIn--;
        sizeOut--;
        while (sizeOut > 0) {
            in.push(out.pop());
            sizeOut--;
        }
        return t;
    }

    public void push(T value) {
        in.push(value);
        sizeIn++;
    }
}