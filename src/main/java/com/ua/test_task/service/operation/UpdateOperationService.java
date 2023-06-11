package com.ua.test_task.service.operation;

import com.ua.test_task.model.UpdateOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;

public class UpdateOperationService {

    private final Memory memory;

    public UpdateOperationService(Memory memory) {
        this.memory = memory;
    }

    public void execute(String line) {
        UpdateOperation updateOperation = OperationInitializationService.createUpdateOperation(line);
        if (updateOperation.getType() == UpdateOperationType.ASK) {
            memory.saveAsk(updateOperation);
        }
        if (updateOperation.getType() == UpdateOperationType.BID) {
            memory.saveBid(updateOperation);
        }
    }
}
