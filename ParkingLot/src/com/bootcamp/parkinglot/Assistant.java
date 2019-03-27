package com.bootcamp.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Assistant {
    private Display display;
    private Map<Integer, Integer> carCount;
    private List<ParkingLot> freeParkingLot;
    private List<ParkingLot> fullParkingLot;


    Assistant() {
        freeParkingLot = new ArrayList<>();
        fullParkingLot = new ArrayList<>();
        this.carCount = new HashMap<>();
    }

    void addDisplay(Display display) {
        this.display = display;
    }

    void addParkingLot(ParkingLot parkingLot) {
        freeParkingLot.add(parkingLot);
    }

    void notifyCarParked(int id) {
        if (this.carCount.get(id) == null) {
            this.carCount.put(id, 1);
            this.display.update(id, this.carCount.get(id));
            return;
        }
        int count = this.carCount.get(id);
        this.carCount.put(id, ++count);
        this.display.update(id, this.carCount.get(id));
    }

    void notifyCarUnparked(int id) {
        int count = this.carCount.get(id);
        this.carCount.put(id, --count);
        this.display.update(id, this.carCount.get(id));
    }
}
