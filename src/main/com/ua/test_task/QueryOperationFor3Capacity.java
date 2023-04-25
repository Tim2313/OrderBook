package com.ua.test_task;

public class QueryOperationFor3Capacity {

    private final String type;
    private final int price;

    public QueryOperationFor3Capacity(String line) {
        String[] splitString = line.split(",");
        type = splitString[1];
        price = Integer.parseInt(splitString[2]);
    }

    public String getSize() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}