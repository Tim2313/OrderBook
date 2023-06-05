package com.ua.test_task.model;

public enum BidOrAskOperation {

    BID("bid"), ASK("ask");

    private final String type;

    BidOrAskOperation(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
