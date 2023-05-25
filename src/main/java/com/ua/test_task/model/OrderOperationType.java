package com.ua.test_task.model;

public enum OrderOperationType {

    SELL("sell"), BUY("buy");

    private final String type;
    OrderOperationType (String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
