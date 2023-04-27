package com.ua.test_task;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private List<UpdateOperation> asks = new ArrayList<>();
    private List<UpdateOperation> bids = new ArrayList<>();

    public int getByPriceAsk(int price) {
        for (int i = 0; i != asks.size(); i++) {
            if (asks.get(i).getPrice() == price) {
                return asks.get(i).getSize();
            }
        }
        return 0;
    }

    public List<UpdateOperation> getAsks() {
        return asks;
    }

    public void saveAsk(UpdateOperation updateOperation) {
        asks.add(updateOperation);
    }

    public void saveBid(UpdateOperation updateOperation) {
        bids.add(updateOperation);
    }

    public List<UpdateOperation> getBids() {
        return bids;
    }

    public int getByPriceBid(int price) {
        for (int i = 0; i != bids.size(); i++) {
            if (bids.get(i).getPrice() == price) {
                return bids.get(i).getSize();
            }
        }
        return 0;
    }


}
