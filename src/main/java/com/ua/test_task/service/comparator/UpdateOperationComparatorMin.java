package com.ua.test_task.service.comparator;

import com.ua.test_task.model.UpdateOperation;

import java.util.Comparator;

public class UpdateOperationComparatorMin implements Comparator<UpdateOperation> {

    public int compare(UpdateOperation lhs, UpdateOperation rhs) {
        int priceLhs = lhs.getPrice();
        int priceRhs = rhs.getPrice();
        return Integer.min(priceLhs, priceRhs);
    }
}
