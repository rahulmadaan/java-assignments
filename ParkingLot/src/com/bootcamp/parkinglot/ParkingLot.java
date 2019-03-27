package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<Car> parkingLot;
    private int capacity;
    private Attendent attendent;
    private boolean isFull;

    ParkingLot(int capacity, Attendent attendent) {
        this.capacity = capacity;
        this.attendent = attendent;
        this.isFull = false;
        this.parkingLot = new ArrayList<>();

    }

    boolean park(Car car) {
        if (!canPark()) return false;
        parkingLot.add(car);
        isParkingLotFull();
        return true;
    }

    private void isParkingLotFull() {
        if (this.parkingLot.size() >= this.capacity) {
            this.isFull = true;
            attendent.setParkingLotFull(this);
        }
    }

    private boolean canPark() {
        return this.parkingLot.size() < this.capacity;
    }

    public boolean unpark(Car car) {
        if (this.parkingLot.contains(car)) {
            notifyParkingLotIsFree();
            this.parkingLot.remove(car);
            this.isFull = false;
            return true;
        }
        return false;
    }

    private void notifyParkingLotIsFree() {
        if (this.isFull) {
            this.attendent.setParkingLotFree(this);
        }
    }
}
