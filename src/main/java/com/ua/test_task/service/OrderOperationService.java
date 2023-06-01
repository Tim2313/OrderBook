package com.ua.test_task.service;

import com.ua.test_task.model.OrderOperation;
import com.ua.test_task.model.OrderOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMax;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMin;

import java.util.Collections;
import java.util.List;

public class OrderOperationService {

    private final Memory memory;
    private final WritterService writterService;

    public OrderOperationService(Memory memory, WritterService writterService) {
        this.memory = memory;
        this.writterService = writterService;
    }

    public void execute(String line) {
        OrderOperation orderOperation = OperationInitializationService.createOrderOperation(line);
        if (orderOperation.getType() == OrderOperationType.SELL) {
            List<UpdateOperation> bids = memory.getBids();

            UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
            int price = max.getPrice();
            int size = max.getSize() - orderOperation.getSize();
            max.setSize(size);
            int orderSize = orderOperation.getSize();
            OrderOperationType typeOfOrder = orderOperation.getType();
            String orderFormat = "After order - %s - %d, we have bid: %d %d\n";
            String orderMassage = String.format(orderFormat, typeOfOrder, orderSize, price, size);
            writterService.write(orderMassage);
        }
        if (orderOperation.getType() == OrderOperationType.BUY) {
            List<UpdateOperation> ask = memory.getBids();

            UpdateOperation min = Collections.max(ask, new UpdateOperationComparatorMin());
            int price = min.getPrice();
            int size = min.getSize() + orderOperation.getSize();
            min.setSize(size);
            // CRUD
            // Create Read Update Delete
            // Update = delete + create
            int orderSize = orderOperation.getSize();
            OrderOperationType typeOfOrder = orderOperation.getType();
            String orderFormat = "After order - %s - %d, we have bid: %d %d\n";
            String orderMassage = String.format(orderFormat, typeOfOrder, orderSize, price, size);
            writterService.write(orderMassage);
        }
    }
}

