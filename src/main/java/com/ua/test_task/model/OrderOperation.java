package com.ua.test_task.model;

public class OrderOperation {

    private final String type;

    private final int size;

    public OrderOperation(String type, int size){
        this.type = type;
        this.size = size;
    }
    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}