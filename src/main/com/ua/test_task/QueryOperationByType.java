package com.ua.test_task;

public class QueryOperationByType {

    private final String type;
    private final int value;

    public QueryOperationByType(String line) {
        String[] splitString = line.split(",");
        type = splitString[1];
        value = Integer.parseInt(splitString[2]);
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}