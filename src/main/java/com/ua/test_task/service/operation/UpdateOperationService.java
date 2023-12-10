package com.ua.test_task.service.operation;

import com.ua.test_task.model.enums.UpdateOperationType;
import com.ua.test_task.model.UpdateOperation;
import com.ua.test_task.service.Memory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateOperationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateOperationService.class);

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
        LOGGER.info("'UpdateOperation' executed.");
    }
}
