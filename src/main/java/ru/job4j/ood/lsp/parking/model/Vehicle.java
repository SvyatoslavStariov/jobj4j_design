package ru.job4j.ood.lsp.parking.model;

public abstract class Vehicle {

    private String model;

    private int size;

    public Vehicle(String model, int size) {
        checkSize(size);
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    protected abstract void checkSize(int size);
}
