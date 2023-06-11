package com.ua.test_task.model;

import com.ua.test_task.model.enums.QueryOperationType;

public class QueryOperationByType {

    private final QueryOperationType type;
    private final int value;

    public QueryOperationByType(QueryOperationType type, int value) {
        this.type = type;
        this.value = value;
    }

    public QueryOperationType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}