package com.ua.test_task.service;

import com.ua.test_task.model.QueryOperationBest;
import com.ua.test_task.model.QueryOperationByType;
import com.ua.test_task.model.QueryOperationType;
import com.ua.test_task.model.UpdateOperation;
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
        String[] splitline = line.split(",");
        if (splitline.length == 3) {
            QueryOperationByType queryOperationByType = OperationInitializationService.createQueryOperationByType(line);
            if (queryOperationByType.getType() == QueryOperationType.SIZE) {
                int size = memory.getByPriceBid(queryOperationByType.getValue());
                int price = queryOperationByType.getValue();
                String formatMassage = "For price:%d the size is: %d.\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);
            }
        } else {
            QueryOperationBest queryOperationBest = OperationInitializationService.createQueryOperationBest(line);
            if (queryOperationBest.getType() == QueryOperationType.BEST_BID) {
                List<UpdateOperation> bids = memory.getBids();
                UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
                int price = max.getPrice();
                int size = max.getSize();
                String formatMassage = "Best_bid:\nprice: %d, size: %d\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);

            }
            if (queryOperationBest.getType() == QueryOperationType.BEST_ASK) {
                List<UpdateOperation> asks = memory.getAsks();

                UpdateOperation max = Collections.max(asks, new UpdateOperationComparatorMax());
                int price = max.getPrice();
                int size = max.getSize();
                String formatMassage = "Best_ask:\nprice: %d, size: %d\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);
            }
        }
    }
}
