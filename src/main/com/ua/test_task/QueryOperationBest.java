package com.ua.test_task;

public class QueryOperationBest {
    private final String type;

    public QueryOperationBest(String line) {
        String[] splitString = line.split(",");
        type = splitString[1];
    }

    public String getType() {
        return type;
    }
}
