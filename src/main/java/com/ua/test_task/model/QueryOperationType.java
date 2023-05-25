package com.ua.test_task.model;

public enum QueryOperationType {

    SIZE("size"), BEST_BID("best_bid"), BEST_ASK("best_ask");

    private final String type;

    QueryOperationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
