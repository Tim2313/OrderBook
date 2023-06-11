package com.ua.test_task.model;

import java.util.HashMap;
import java.util.Map;

public enum OrderOperationType {

    SELL("sell"), BUY("buy");

    private final String title;

    private static final Map<String, OrderOperationType> TITLE_MAP = new HashMap<>();

    static {
        TITLE_MAP.put(SELL.getTitle(), SELL);
        TITLE_MAP.put(BUY.getTitle(), BUY);
    }

    OrderOperationType(String type) {
        this.title = type;
    }

    public String getTitle() {
        return title;
    }

    public static OrderOperationType getByTitle(String title){
        return TITLE_MAP.get(title);
    }
}

