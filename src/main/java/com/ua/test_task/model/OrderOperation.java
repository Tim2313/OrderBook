package com.ua.test_task.model;

import com.ua.test_task.model.enums.OrderOperationType;

public class OrderOperation {

    private final OrderOperationType type;

    private final int size;

    public OrderOperation(OrderOperationType type, int size) {
        this.type = type;
        this.size = size;
    }

    public OrderOperationType getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
