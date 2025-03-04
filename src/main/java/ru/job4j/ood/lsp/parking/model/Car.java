package ru.job4j.ood.lsp.parking.model;


public class Car extends Vehicle {

    public Car(String model, int size) {
        super(model, size);
    }

    @Override
    protected void checkSize(int size) {
        if (size != 1) {
            throw new IllegalArgumentException("Size must be 1");
        }
    }
}
