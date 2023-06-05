package com.ua.test_task.model;

public class UpdateOperation {
    private final int price;
    private int size;
    private final BidOrAskOperation type;

    public UpdateOperation(int price, int size, BidOrAskOperation type) {
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

    public BidOrAskOperation getType() {
        return type;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
