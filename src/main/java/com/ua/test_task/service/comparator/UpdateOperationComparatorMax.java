package com.ua.test_task.service.comparator;

import com.ua.test_task.model.UpdateOperation;

import java.util.Comparator;

public class UpdateOperationComparatorMax implements Comparator<UpdateOperation> {

    public int compare(UpdateOperation lhs, UpdateOperation rhs) {
        int priceLhs = lhs.getPrice();
        int sizeLhs = lhs.getSize();
        int sumLhs = priceLhs + sizeLhs;

        int priceRhs = rhs.getPrice();
        int sizeRhs = rhs.getSize();
        int sumRhs = priceRhs + sizeRhs;

        return Integer.compare(sumLhs, sumRhs);
    }
}
