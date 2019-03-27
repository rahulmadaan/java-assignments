package com.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldParkACarToTheParkingLot() {
        Display display = new Display();
        Attendant attendant = new Attendant(display);
        ParkingLot parkingLot = new ParkingLot(20, attendant, 1);
        Car car = new Car(1);
        assertTrue(parkingLot.park(car));
    }


    @Test
    void shouldNotParkACarToTheParkingLotIfItsCapacityIfFull() {
        Display display = new Display();
        Attendant attendant = new Attendant(display);
        ParkingLot parkingLot = new ParkingLot(2, attendant, 1);
        Car car = new Car(1);
        parkingLot.park(car);
        parkingLot.park(car);
        parkingLot.park(car);
        assertFalse(parkingLot.park(car));
    }

    @Test
    void shouldNotifyAttendantIfParkingLotIsFull() {
        Display display = new Display();
        MockAttendant attendant = new MockAttendant(display);
        ParkingLot parkingLot = new ParkingLot(3, attendant, 1);
        Car car = new Car(1);
        parkingLot.park(car);
        parkingLot.park(car);
        parkingLot.park(car);

        assertTrue(attendant.isNotify);
    }

    @Test
    void shouldNotifyAttendantIfParkingLotIsFree() {
        Display display = new Display();
        MockAttendant attendant = new MockAttendant(display);
        ParkingLot parkingLot = new ParkingLot(2, attendant, 1);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        parkingLot.park(car1);
        parkingLot.park(car2);
        parkingLot.unPark(1);

        assertTrue(attendant.isNotify);
    }

    @Test
    void ShouldBeAbleToUnParkACarIfItPresent() {
        Display display = new Display();
        Attendant attendant = new Attendant(display);
        ParkingLot parkingLot = new ParkingLot(3, attendant, 1);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        parkingLot.park(car1);
        parkingLot.park(car2);
        assertTrue(parkingLot.unPark(2));
    }

    @Test
    void ShouldNotBeAbleToUnParkACarIfItNotPresent() {
        Display display = new Display();
        Attendant attendant = new Attendant(display);
        ParkingLot parkingLot = new ParkingLot(3, attendant, 1);
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        parkingLot.park(car1);
        parkingLot.park(car2);
        assertFalse(parkingLot.unPark(3));
    }

    @Test
    void shouldReturnIdOfParkingLot() {
        Display display = new Display();
        Attendant attendant = new Attendant(display);
        ParkingLot parkingLot = new ParkingLot(10, attendant, 1);
        int id = parkingLot.getId();
        int expectedId = 1;
        assertEquals(expectedId, id);
    }

    @Test
    void shouldReturnNumberOfParkedCarsInParkingLot() {
        Display display = new Display();
        Attendant attendant = new Attendant(display);
        ParkingLot parkingLot = new ParkingLot(10, attendant, 1);
        parkingLot.park(new Car(1));
        int id = parkingLot.getCarsCount();
        int expectedId = 1;
        System.out.println(display.toString());
        assertEquals(expectedId, id);
    }


}

class MockAttendant extends Attendant {
    boolean isNotify = false;

    MockAttendant(Display display) {
        super(display);
    }

    @Override
    void notifyParkingLotFull(int parkingLot) {
        isNotify = true;
    }

    @Override
    public void notifyParkingLotFree(int parkingLot) {
        isNotify = true;
    }
}

