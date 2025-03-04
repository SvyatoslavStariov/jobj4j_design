package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Vehicle;

public class ParkingTruck extends ParkingVehicle {

    public ParkingTruck(int size) {
        super(size);
    }

    @Override
    protected boolean canParking(Vehicle car) {
        return true;
    }
}
