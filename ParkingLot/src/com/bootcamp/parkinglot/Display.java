package com.bootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class Display {
    private static StringBuilder displayData;
    private static Display ourInstance = new Display();
    private HashMap<Integer, Integer> parkingLotStatus = new HashMap<>();

    public static Display getInstance() {
        return ourInstance;
    }

    @Override
    public String toString() {
        StringBuilder displayData = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : this.parkingLotStatus.entrySet()) {
            displayData.append(entry.getKey());
            displayData.append(" : ");
            displayData.append(entry.getValue());
            displayData.append("\n");
        }
        return displayData.toString();
    }

    void update(Integer id, Integer count) {
        this.parkingLotStatus.putIfAbsent(id, 0);
        this.parkingLotStatus.put(id, count);
    }
}
