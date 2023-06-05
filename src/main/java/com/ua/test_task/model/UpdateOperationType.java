package com.ua.test_task.model;

import java.util.HashMap;
import java.util.Map;

public enum UpdateOperationType {

    BID("bid"), ASK("ask");

    private final String title;

    public static final Map<String, UpdateOperationType> TITLE_MAP = new HashMap<>();

    static {
        TITLE_MAP.put(UpdateOperationType.ASK.getTitle(), UpdateOperationType.ASK);
        TITLE_MAP.put(UpdateOperationType.BID.getTitle(), UpdateOperationType.BID);
    }

    UpdateOperationType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
