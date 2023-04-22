package com.ua.test_task;

public class UpdateOperation {

    private final int price;
    private final int size;
    private final String type;

    public UpdateOperation(String line) {
        String[] splitString = line.split(",");
        price = Integer.parseInt(splitString[1]);
        size = Integer.parseInt(splitString[2]);
        type = splitString[3];
    }

    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }
}
