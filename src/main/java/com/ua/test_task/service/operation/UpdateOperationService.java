package com.ua.test_task.service.operation;

import com.ua.test_task.model.BidOrAskOperation;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;

public class UpdateOperationService {

    private final Memory memory;

    public UpdateOperationService(Memory memory) {
        this.memory = memory;
    }

    public void execute(String line) {
        UpdateOperation updateOperation = OperationInitializationService.createUpdateOperation(line);
        if (updateOperation.getType() == BidOrAskOperation.ASK) {
            memory.saveAsk(updateOperation);
        }
        if (updateOperation.getType() == BidOrAskOperation.BID) {
            memory.saveBid(updateOperation);
        }
    }
}
