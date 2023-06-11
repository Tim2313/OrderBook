package com.ua.test_task.service.operation;

import com.ua.test_task.model.OperationType;
import com.ua.test_task.service.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class OperationTypeProcessor {

    private final Map<OperationType, Consumer<String>> operationTypeProcessor = new HashMap<>();

    public OperationTypeProcessor(Memory memory, WritterService writterService) {
        UpdateOperationService updateOperationService = new UpdateOperationService(memory);
        QueryOperationService queryOperationService = new QueryOperationService(memory, writterService);
        OrderOperationService orderOperationService = new OrderOperationService(memory);

        operationTypeProcessor.put(OperationType.UPDATE_OPERATION, updateOperationService::execute);
        operationTypeProcessor.put(OperationType.QUERY_OPERATION, queryOperationService::execute);
        operationTypeProcessor.put(OperationType.ORDER_OPERATION, orderOperationService::execute);
    }

    public void process(String line) {
        char operation = line.charAt(0);
        OperationType operationType = OperationType.getBySymbol(operation);
        operationTypeProcessor.get(operationType).accept(line);
    }
}
