package com.ua.test_task.model;

public class UpdateOperation {
    private final int price;
    private int size;
    private final String type;

    public UpdateOperation(int price, int size, String type) {
        this.price = price;
        this.size = size;
        this.type = type;
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

    public void setSize(int size) {
        this.size = size;
    }

}
