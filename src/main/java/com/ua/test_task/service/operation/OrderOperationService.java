package com.ua.test_task.service.operation;

import com.ua.test_task.model.OrderOperation;
import com.ua.test_task.model.enums.OrderOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;
import com.ua.test_task.service.comparator.UpdateOperationComparator;


import java.util.*;

public class OrderOperationService {

    private final Memory memory;

    public OrderOperationService(Memory memory) {
        this.memory = memory;
    }

    public void execute(String line) {
        OrderOperation orderOperation = OperationInitializationService.createOrderOperation(line);
        int orderSize = orderOperation.getSize();
        if (orderOperation.getType() == OrderOperationType.SELL) {
            List<UpdateOperation> bids = memory.getBids();
            bids.sort(new UpdateOperationComparator());
            Collections.reverse(bids);
            Queue<UpdateOperation> updateOperationQueue = new ArrayDeque<>(bids);

            while (orderSize != 0) {
                UpdateOperation updateOperation = updateOperationQueue.poll();
                int currentSize = updateOperation.getSize();
                if (orderSize >= currentSize) {
                    updateOperation.setSize(0);
                    orderSize -= currentSize;
                } else {
                    currentSize -= orderSize;
                    updateOperation.setSize(currentSize);
                    orderSize = 0;
                }
            }
        }
        if (orderOperation.getType() == OrderOperationType.BUY) {
            List<UpdateOperation> ask = memory.getAsks();
            ask.sort(new UpdateOperationComparator());
            Queue<UpdateOperation> updateOperationQueue = new ArrayDeque<>(ask);

            while (orderSize != 0) {
                UpdateOperation updateOperation = updateOperationQueue.poll();
                int currentSize = updateOperation.getSize();
                if (orderSize >= currentSize) {
                    updateOperation.setSize(0);
                    orderSize -= currentSize;
                } else {
                    currentSize -= orderSize;
                    updateOperation.setSize(currentSize);
                    orderSize = 0;
                }
            }
        }
    }
}


