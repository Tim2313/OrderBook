package com.ua.test_task.service.operation;

import com.ua.test_task.model.QueryOperationBest;
import com.ua.test_task.model.QueryOperationByType;
import com.ua.test_task.model.enums.QueryOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;
import com.ua.test_task.service.WritterService;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMax;

import java.util.Collections;
import java.util.List;

public class QueryOperationService {

    private final Memory memory;
    private final WritterService writterService;

    public QueryOperationService(Memory memory, WritterService writterService) {
        this.memory = memory;
        this.writterService = writterService;
    }

    public void execute(String line) {
        String[] splitLine = line.split(",");
        if (splitLine.length == 3) {
            QueryOperationByType queryOperationByType = OperationInitializationService.createQueryOperationByType(line);
            if (queryOperationByType.getType() == QueryOperationType.SIZE) {
                int size = memory.getByPriceBid(queryOperationByType.getValue());
                String formatMassage = "%d\n";
                String massage = String.format(formatMassage, size);
                writterService.write(massage);
            }
        } else {
            QueryOperationBest queryOperationBest = OperationInitializationService.createQueryOperationBest(line);
            if (queryOperationBest.getType() == QueryOperationType.BEST_BID) {
                List<UpdateOperation> bids = memory.getBids();
                UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
                int price = max.getPrice();
                int size = max.getSize();
                String formatMassage = "%d %d\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);

            }
            if (queryOperationBest.getType() == QueryOperationType.BEST_ASK) {
                List<UpdateOperation> asks = memory.getAsks();
                UpdateOperation max = Collections.max(asks, new UpdateOperationComparatorMax());
                int price = max.getPrice();
                int size = max.getSize();
                String formatMassage = "%d %d\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);
            }
        }
    }
}
