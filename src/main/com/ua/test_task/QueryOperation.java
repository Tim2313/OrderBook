package com.ua.test_task;

import javax.management.Query;

public class QueryOperation {
    private final String type;

    public QueryOperation(String line) {
        String[] splitString = line.split(",");
        type = splitString[1];
    }

    public String getType() {
        return type;
    }
}
