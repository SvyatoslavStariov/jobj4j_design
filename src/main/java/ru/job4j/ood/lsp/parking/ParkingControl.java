package ru.job4j.ood.lsp.parking;

import ru.job4j.ood.lsp.parking.model.Vehicle;

import java.util.List;

public class ParkingControl {

    private final List<IParking> parking;

    public ParkingControl(List<IParking> parking) {
        this.parking = parking;
    }

    public void park(Vehicle vehicle) {
        for (IParking park : parking) {
            park.addVehicle(vehicle);
        }
    }
}
