package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

class Attendent {
    List<ParkingLot> freeParkingLot;
    List<ParkingLot> fullParkingLot;


    Attendent() {
        freeParkingLot = new ArrayList<>();
        fullParkingLot = new ArrayList<>();
    }


    void addParkingLot(ParkingLot parkingLot) {
        freeParkingLot.add(parkingLot);
    }

    void setParkingLotFull(ParkingLot parkingLot) {
        freeParkingLot.remove(parkingLot);
        fullParkingLot.add(parkingLot);
    }

    boolean isParkingLotFull(ParkingLot parkingLot) {
        return fullParkingLot.contains(parkingLot);
    }

    public void setParkingLotFree(ParkingLot parkingLot) {
        this.fullParkingLot.remove(parkingLot);
        this.freeParkingLot.add(parkingLot);
    }
}
