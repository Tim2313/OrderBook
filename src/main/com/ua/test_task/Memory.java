package com.ua.test_task;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    private List<UpdateOperation> asks = new ArrayList<>();

    public int getByPrice(int price) {
        for (int i = 0; i != asks.size(); i++) {
            if (asks.get(i).getPrice() == price) {
                return asks.get(i).getSize();
            }
        }
        return 0;
    }

    public void saveAsk(UpdateOperation updateOperation) {
        asks.add(updateOperation);
    }


    private List<UpdateOperation> bids = new ArrayList<>();

    public void saveBid(UpdateOperation updateOperation) {
        bids.add(updateOperation);
    }

}
