package com.ua.test_task.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
    ORDER_OPERATION('o'), UPDATE_OPERATION('u'), QUERY_OPERATION('q');

    private final char symbol;

    private static final Map<Character, OperationType> SYMBOL_MAP = new HashMap<>();

    static {
        SYMBOL_MAP.put(ORDER_OPERATION.getSymbol(), ORDER_OPERATION);
        SYMBOL_MAP.put(UPDATE_OPERATION.getSymbol(), UPDATE_OPERATION);
        SYMBOL_MAP.put(QUERY_OPERATION.getSymbol(), QUERY_OPERATION);
    }

    OperationType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperationType getBySymbol(char symbol) {
        return SYMBOL_MAP.get(symbol);
    }
}
