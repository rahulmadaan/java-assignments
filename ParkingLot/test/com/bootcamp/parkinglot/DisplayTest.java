package com.bootcamp.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayTest {
    @Test
    void shouldUpdateTheCarCountAndReturnInString() {
        Display display = new Display();
        display.update(1, 1);
        display.update(1, 2);
        display.update(2, 1);

        String expected = "1 : 2" + "\n" + "2 : 1" + "\n";
        assertEquals(expected, display.toString());
    }
}