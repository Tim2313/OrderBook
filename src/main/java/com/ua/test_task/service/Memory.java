package com.ua.test_task.service;

import com.ua.test_task.model.UpdateOperation;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private final List<UpdateOperation> asks = new ArrayList<>();
    private final List<UpdateOperation> bids = new ArrayList<>();

    public List<UpdateOperation> getAsks() {
        return filterEmptySize(asks);
    }

    public List<UpdateOperation> getBids() {
        return filterEmptySize(bids);
    }

    public void saveAsk(UpdateOperation updateOperation) {
        asks.add(updateOperation);
    }

    public void saveBid(UpdateOperation updateOperation) {
        bids.add(updateOperation);
    }

    public int getByPriceBid(int price) {

        for (int i = 0; i != bids.size(); i++) {
            if (bids.get(i).getPrice() == price) {
                return bids.get(i).getSize();
            }
        }
        return 0;
    }

    public int getByPriceAsk(int price) {
        for (int i = 0; i != asks.size(); i++) {
            if (asks.get(i).getPrice() == price) {
                return asks.get(i).getSize();
            }
        }
        return 0;
    }

    private static List<UpdateOperation> filterEmptySize(List<UpdateOperation> all) {
        List<UpdateOperation> result = new ArrayList<>();
        for (UpdateOperation value : all) {
            if (value.getSize() > 0) {
                result.add(value);
            }
        }
        return result;
    }
}
