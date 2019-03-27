package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private final int id;
    private List<Car> parkingLot;
    private int capacity;
    private Attendant attendant;
    private boolean isFull;

    ParkingLot(int capacity, Attendant attendant, int id) {
        this.capacity = capacity;
        this.attendant = attendant;
        this.isFull = false;
        this.id = id;
        this.parkingLot = new ArrayList<>();
    }

    boolean park(Car car) {
        if (!canPark()) return false;
        parkingLot.add(car);
        attendant.notifyCarParked(this.id);
        isParkingLotFull();
        return true;
    }

    private void isParkingLotFull() {
        if (this.parkingLot.size() >= this.capacity) {
            this.isFull = true;
            attendant.notifyParkingLotFull(this.id);
        }
    }

    private boolean canPark() {
        return this.parkingLot.size() < this.capacity;
    }

    boolean unPark(int id) {
        for (Car car : this.parkingLot) {
            if (car.getId() == id) {
                notifyParkingLotIsFree();
                this.parkingLot.remove(car);
                this.isFull = false;
                attendant.notifyCarUnparked(this.id);
                return true;
            }
        }
        return false;
    }

    private void notifyParkingLotIsFree() {
        if (this.isFull) {
            this.attendant.notifyParkingLotFree(this.id);
        }
    }

    int getId() {
        return this.id;
    }

    int getCarsCount() {
        return parkingLot.size();
    }

    StringBuilder getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(this.id);
        details.append(this.parkingLot.size());
        details.append(this.capacity);
        return details;
    }
}
