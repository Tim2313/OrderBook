package com.ua.test_task.model;

public class QueryOperationBest {
    private final QueryOperationType type;

    public QueryOperationBest(QueryOperationType type){
        this.type = type;
    }

    public QueryOperationType getType() {
        return type;
    }
}
