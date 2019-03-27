package com.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttendentTest {
    @Test
    void shouldReturnFalseForParkingLotStatus() {
        Attendent attendent = new Attendent();
        ParkingLot parkingLot = new ParkingLot(2, attendent);
        attendent.addParkingLot(parkingLot);
        assertFalse(attendent.isParkingLotFull(parkingLot));
    }

    @Test
    void shouldReturnTrueForParkingLotStatusIfParkingLotIsFull() {
        Attendent attendent = new Attendent();
        ParkingLot parkingLot = new ParkingLot(2, attendent);
        attendent.setParkingLotFull(parkingLot);
        assertTrue(attendent.isParkingLotFull(parkingLot));
    }
}