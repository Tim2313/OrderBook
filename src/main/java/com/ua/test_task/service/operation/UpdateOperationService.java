package com.ua.test_task.service.operation;

import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;
import com.ua.test_task.service.operation.OperationInitializationService;

public class UpdateOperationService {

    private final Memory memory;

    public UpdateOperationService(Memory memory) {
        this.memory = memory;
    }

    public void execute(String line) {
        UpdateOperation updateOperation = OperationInitializationService.createUpdateOperation(line);
        if (updateOperation.getType().equals("ask")) {
            memory.saveAsk(updateOperation);
        }
        if (updateOperation.getType().equals("bid")) {
            memory.saveBid(updateOperation);
        }
    }
}
