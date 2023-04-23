package com.ua.test_task;

import javax.management.Query;

public class QueryOperation {
    private final String type;
    private final int price;

    public QueryOperation(String line) {
        String[] splitString = line.split(",");
        type = splitString[1];
        price = Integer.parseInt(splitString[2]);
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
