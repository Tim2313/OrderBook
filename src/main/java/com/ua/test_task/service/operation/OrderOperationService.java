package com.ua.test_task.service.operation;

import com.ua.test_task.model.OrderOperation;
import com.ua.test_task.model.OrderOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMax;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMin;

import java.util.Collections;
import java.util.List;

public class OrderOperationService {

    private final Memory memory;

    public OrderOperationService(Memory memory) {
        this.memory = memory;
    }

    public void execute(String line) {
        OrderOperation orderOperation = OperationInitializationService.createOrderOperation(line);
        if (orderOperation.getType() == OrderOperationType.SELL) {
            List<UpdateOperation> bids = memory.getBids();
            UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
            int size = max.getSize() - orderOperation.getSize();
            max.setSize(size);
        }
        if (orderOperation.getType() == OrderOperationType.BUY) {
            List<UpdateOperation> ask = memory.getBids();
            UpdateOperation min = Collections.max(ask, new UpdateOperationComparatorMin());
            int size = min.getSize() + orderOperation.getSize();
            min.setSize(size);
        }
    }
}

