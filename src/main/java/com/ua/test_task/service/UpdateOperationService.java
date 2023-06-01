package com.ua.test_task.service;

import com.ua.test_task.Main;
import com.ua.test_task.model.UpdateOperation;

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
