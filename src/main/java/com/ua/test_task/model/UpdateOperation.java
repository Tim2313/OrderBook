package com.ua.test_task.model;

import com.ua.test_task.model.enums.UpdateOperationType;

public class UpdateOperation {
    private final int price;
    private int size;
    private final UpdateOperationType type;

    public UpdateOperation(int price, int size, UpdateOperationType type) {
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

    public UpdateOperationType getType() {
        return type;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
