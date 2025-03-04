package ru.job4j.ood.lsp.parking.model;

public class Truck extends Vehicle {

    public Truck(String model, int size) {
        super(model, size);
    }

    @Override
    protected void checkSize(int size) {
        if (size <= 1) {
            throw new IllegalArgumentException("Size must be more 1");
        }
    }
}
