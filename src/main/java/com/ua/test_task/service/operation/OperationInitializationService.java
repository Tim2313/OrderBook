package com.ua.test_task.service.operation;

import com.ua.test_task.model.*;

public final class OperationInitializationService {
    private static final String LINE_DELIMITER = ",";

    private OperationInitializationService() {

    }

    public static UpdateOperation createUpdateOperation(String line) {
        String[] splitString = line.split(LINE_DELIMITER);
        int price = Integer.parseInt(splitString[1]);
        int size = Integer.parseInt(splitString[2]);
        String type = splitString[3];
        UpdateOperationType updateOperationType = UpdateOperationType.getByTitle(type);
        return new UpdateOperation(price, size, updateOperationType);
    }

    public static QueryOperationBest createQueryOperationBest(String line) {
        String[] splitString = line.split(LINE_DELIMITER);
        String type = splitString[1];
        QueryOperationType queryOperationType = QueryOperationType.getByTitle(type);
        return new QueryOperationBest(queryOperationType);
    }


    public static OrderOperation createOrderOperation(String line) {
        String[] splitString = line.split(LINE_DELIMITER);
        String type = splitString[1];
        OrderOperationType orderOperationType = OrderOperationType.getByTitle(type);
        int size = Integer.parseInt(splitString[2]);
        return new OrderOperation(orderOperationType, size);
    }

    public static QueryOperationByType createQueryOperationByType(String line) {
        String[] splitString = line.split(LINE_DELIMITER);
        String type = splitString[1];
        QueryOperationType queryOperationType = QueryOperationType.getByTitle(type);
        int value = Integer.parseInt(splitString[2]);
        return new QueryOperationByType(queryOperationType, value);
    }

}
