package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingVehicle implements IParking {

    protected final List<Vehicle> trucks = new ArrayList<>();

    protected int size;

    protected ParkingVehicle(int size) {
        this.size = size;
    }

    public List<Vehicle> getTrucks() {
        return trucks;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void addVehicle(Vehicle car) {
        int tempSize = size - car.getSize();
        if (!canParking(car) || tempSize < 0) {
            return;
        }
        trucks.add(car);
        size = tempSize;
    }

    protected abstract boolean canParking(Vehicle car);
}
