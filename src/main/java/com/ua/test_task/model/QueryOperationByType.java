package com.ua.test_task.model;

public class QueryOperationByType {

    private final String type;
    private final int value;

    public QueryOperationByType(String type, int value){
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}