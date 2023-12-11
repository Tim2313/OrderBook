package com.ua.test_task.service.operation;

import com.ua.test_task.model.QueryOperationBest;
import com.ua.test_task.model.QueryOperationByType;
import com.ua.test_task.model.enums.QueryOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;
import com.ua.test_task.service.WritterService;
import com.ua.test_task.service.comparator.UpdateOperationComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class QueryOperationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryOperationService.class);
    private final Memory memory;
    private final WritterService writterService;

    public QueryOperationService(Memory memory, WritterService writterService) {
        this.memory = memory;
        this.writterService = writterService;
    }

    public void execute(String line) {
        boolean isQueryByType = isQueryByType(line);
        if (isQueryByType) {
            QueryOperationByType queryOperationByType = OperationInitializationService.createQueryOperationByType(line);
            if (queryOperationByType.getType() == QueryOperationType.SIZE) {
                int bidSize = memory.getByPriceBid(queryOperationByType.getValue());
                int askSize = memory.getByPriceAsk(queryOperationByType.getValue());
                int size = bidSize + askSize;
                String formatMassage = "%d\n";
                String massage = String.format(formatMassage, size);
                writterService.write(massage);
            }
        } else {
            QueryOperationBest queryOperationBest = OperationInitializationService.createQueryOperationBest(line);
            if (queryOperationBest.getType() == QueryOperationType.BEST_BID) {
                List<UpdateOperation> bids = memory.getBids();
                UpdateOperation max = Collections.max(bids, new UpdateOperationComparator());
                int price = max.getPrice();
                int size = max.getSize();
                String formatMassage = "%d,%d\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);
            }
            if (queryOperationBest.getType() == QueryOperationType.BEST_ASK) {
                List<UpdateOperation> asks = memory.getAsks();
                UpdateOperation max = Collections.max(asks, new UpdateOperationComparator());
                int price = max.getPrice();
                int size = max.getSize();
                String formatMassage = "%d,%d\n";
                String massage = String.format(formatMassage, price, size);
                writterService.write(massage);
            }
        }
        LOGGER.info("'QueryOperation' executed.");
    }

    private boolean isQueryByType(String line) {
        String[] splitLine = line.split(",");
        return splitLine.length == 3;
    }
}
