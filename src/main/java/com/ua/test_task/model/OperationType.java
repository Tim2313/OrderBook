package com.ua.test_task.model;

public enum OperationType {
    ORDER_OPERATION('o'), UPDATE_OPERATION('u'), QUERY_OPERATION('q');

    private final char symbol;

    OperationType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
