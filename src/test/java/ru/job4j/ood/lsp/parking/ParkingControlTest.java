package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.parking.model.Car;
import ru.job4j.ood.lsp.parking.model.Truck;
import ru.job4j.ood.lsp.parking.model.Vehicle;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingControlTest {

    @Test
    void whenParkingCarContainsTrucksAndCarsAndParkingTrucksIsEmpty() {
        Vehicle truck = new Truck("Truck", 3);
        Vehicle car1 = new Car("Lada", 1);
        Vehicle car2 = new Car("Lada", 1);
        ParkingTruck parkingTruck = new ParkingTruck(2);
        ParkingCar parkingCar = new ParkingCar(5);
        ParkingControl parkingControl = new ParkingControl(
            List.of(parkingTruck, parkingCar)
        );
        parkingControl.park(truck);
        parkingControl.park(car1);
        parkingControl.park(car2);
        List<Vehicle> resultTrucks = parkingTruck.getTrucks();
        List<Vehicle> resultCars = parkingCar.getTrucks();
        assertThat(resultTrucks).isEmpty();
        assertThat(resultCars).contains(truck, car1, car2);
        assertThat(parkingTruck.getSize()).isEqualTo(2);
        assertThat(parkingCar.getSize()).isZero();
    }

    @Test
    void whenParkingCarContainsCarAndParkingTruckContainsTrucks() {
        Vehicle truck = new Truck("Truck", 4);
        Vehicle car = new Car("Lada", 1);
        ParkingTruck parkingTruck = new ParkingTruck(8);
        ParkingCar parkingCar = new ParkingCar(3);
        ParkingControl parkingControl = new ParkingControl(
            List.of(parkingTruck, parkingCar)
        );
        parkingControl.park(truck);
        parkingControl.park(car);
        List<Vehicle> resultTrucks = parkingTruck.getTrucks();
        List<Vehicle> resultCars = parkingCar.getTrucks();
        assertThat(resultTrucks).containsOnly(truck);
        assertThat(resultCars).containsOnly(car);
        assertThat(parkingTruck.getSize()).isEqualTo(4);
        assertThat(parkingCar.getSize()).isEqualTo(2);
    }

    @Test
    void whenParkingIsNotPlace() {
        Vehicle truck = new Truck("Truck", 4);
        Vehicle car = new Car("Lada", 1);
        ParkingTruck parkingTruck = new ParkingTruck(1);
        ParkingCar parkingCar = new ParkingCar(0);
        ParkingControl parkingControl = new ParkingControl(
            List.of(parkingTruck, parkingCar)
        );
        parkingControl.park(truck);
        parkingControl.park(car);
        List<Vehicle> resultTrucks = parkingTruck.getTrucks();
        List<Vehicle> resultCars = parkingCar.getTrucks();
        assertThat(resultTrucks).isEmpty();
        assertThat(resultCars).isEmpty();
        assertThat(parkingTruck.getSize()).isEqualTo(1);
        assertThat(parkingCar.getSize()).isZero();
    }
}