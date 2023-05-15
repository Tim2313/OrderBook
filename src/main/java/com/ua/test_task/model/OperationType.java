package com.ua.test_task.model;

public enum OperationType {
    OrderOperation('o'), UpdateOperation('u'), QueryOperation('q');

    private final char symbol;

    OperationType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
