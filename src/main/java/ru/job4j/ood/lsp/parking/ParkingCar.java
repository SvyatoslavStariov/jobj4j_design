package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Vehicle;

public class ParkingCar extends ParkingVehicle {

    public ParkingCar(int size) {
        super(size);
    }

    @Override
    protected boolean canParking(Vehicle car) {
        return true;
    }
}
