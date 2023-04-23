package com.ua.test_task;

public class OrderOperation {

    private final String type;

    private final int size;

    public OrderOperation(String line) {
        String[] splitString = line.split(",");
        type = splitString[1];
        size = Integer.parseInt(splitString[2]);
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}