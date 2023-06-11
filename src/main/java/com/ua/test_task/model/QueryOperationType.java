package com.ua.test_task.model;

import java.util.HashMap;
import java.util.Map;

public enum QueryOperationType {

    SIZE("size"), BEST_BID("best_bid"), BEST_ASK("best_ask");

    private final String title;

    private static final Map<String, QueryOperationType> TITLE_MAP = new HashMap<>();

    static {
        TITLE_MAP.put(BEST_ASK.getTitle(), BEST_ASK);
        TITLE_MAP.put(BEST_BID.getTitle(), BEST_BID);
        TITLE_MAP.put(SIZE.getTitle(), SIZE);
    }

    QueryOperationType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static QueryOperationType getByTitle(String title){
        return TITLE_MAP.get(title);
    }
}
