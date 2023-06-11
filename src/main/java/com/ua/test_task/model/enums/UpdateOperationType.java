package com.ua.test_task.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum UpdateOperationType {

    BID("bid"), ASK("ask");

    private final String title;

    private static final Map<String, UpdateOperationType> TITLE_MAP = new HashMap<>();

    static {
        TITLE_MAP.put(ASK.getTitle(), ASK);
        TITLE_MAP.put(BID.getTitle(), BID);
    }

    UpdateOperationType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static UpdateOperationType getByTitle(String title){
        return TITLE_MAP.get(title);
    }
}
