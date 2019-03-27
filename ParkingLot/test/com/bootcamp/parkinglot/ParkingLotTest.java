package com.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingLotTest {

    @Test
    void shouldParkACarToTheParkingLot() {
        Attendent attendent = new Attendent();
        ParkingLot parkingLot = new ParkingLot(20, attendent);
        Car car = new Car();
        assertTrue(parkingLot.park(car));
    }


    @Test
    void shouldNotParkACarToTheParkingLotIfItsCapacityIfFull() {
        Attendent attendent = new Attendent();
        ParkingLot parkingLot = new ParkingLot(2, attendent);
        Car car = new Car();
        parkingLot.park(car);
        parkingLot.park(car);
        parkingLot.park(car);
        assertFalse(parkingLot.park(car));
    }

    @Test
    void shouldNotifyAttendentIfParkingLotIsFull() {
        MockAttendent attendent = new MockAttendent();
        ParkingLot parkingLot = new ParkingLot(3, attendent);
        Car car = new Car();
        parkingLot.park(car);
        parkingLot.park(car);
        parkingLot.park(car);

        assertTrue(attendent.isNotify);
    }

    @Test
    void shouldNotifyAttendentIfParkingLotIsFree() {
        MockAttendent attendent = new MockAttendent();
        ParkingLot parkingLot = new ParkingLot(3, attendent);
        Car car = new Car();
        parkingLot.park(car);
        parkingLot.park(car);
        parkingLot.park(car);

        assertTrue(attendent.isNotify);
    }

    @Test
    void ShouldBeAbleToUnparkACarIfItPresent() {
        Attendent attendent = new Attendent();
        ParkingLot parkingLot = new ParkingLot(3, attendent);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.park(car1);
        parkingLot.park(car2);
        assertTrue(parkingLot.unpark(car2));
    }
    @Test
    void ShouldNotBeAbleToUnparkACarIfItNotPresent() {
        Attendent attendent = new Attendent();
        ParkingLot parkingLot = new ParkingLot(3, attendent);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLot.park(car1);
        parkingLot.park(car2);
        assertFalse(parkingLot.unpark(car3));
    }

}

class MockAttendent extends Attendent{
    boolean isNotify = false;

    @Override
    void setParkingLotFull(ParkingLot parkingLot) {
        isNotify = true;
    }

    @Override
    public void setParkingLotFree(ParkingLot parkingLot) {
        isNotify = true;
    }
}

