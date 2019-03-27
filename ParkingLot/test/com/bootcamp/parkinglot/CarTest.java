package com.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    void shouldReturnIdOfCar() {
        Car car = new Car(1);
        int id = car.getId();
        int expectedId = 1;
        assertEquals(expectedId, id);
    }
}