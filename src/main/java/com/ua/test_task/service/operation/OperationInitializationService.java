package com.ua.test_task.service.operation;

import com.ua.test_task.model.*;

public class OperationInitializationService {
    public static UpdateOperation createUpdateOperation(String line) {
        String[] splitString = line.split(",");
        int price = Integer.parseInt(splitString[1]);
        int size = Integer.parseInt(splitString[2]);
        String type = splitString[3];
        UpdateOperationType bidOrAskOperation = parseUpdateOperationType(type);
        return new UpdateOperation(price, size, bidOrAskOperation);
    }

    public static QueryOperationBest createQueryOperationBest(String line) {
        String[] splitString = line.split(",");
        String type = splitString[1];
        QueryOperationType queryOperationType = parseQueryOperationType(type);
        return new QueryOperationBest(queryOperationType);
    }


    public static OrderOperation createOrderOperation(String line) {
        String[] splitString = line.split(",");
        String type = splitString[1];
        OrderOperationType orderOperationType = parseOrderOperationType(type);
        int size = Integer.parseInt(splitString[2]);
        return new OrderOperation(orderOperationType, size);
    }

    public static QueryOperationByType createQueryOperationByType(String line) {
        String[] splitString = line.split(",");
        String type = splitString[1];
        QueryOperationType queryOperationType = parseQueryOperationType(type);
        int value = Integer.parseInt(splitString[2]);
        return new QueryOperationByType(queryOperationType, value);
    }

    public static OperationType parseOperationType(char operation) {
        OperationType[] allOperation = OperationType.values();

        for (OperationType operationType : allOperation) {
            char symbol = operationType.getSymbol();
            if (symbol == operation) {
                return operationType;
            }
        }

        return null;
    }

    public static QueryOperationType parseQueryOperationType(String type) {
        QueryOperationType[] allQueryOperationTypes = QueryOperationType.values();

        for (QueryOperationType queryOperationType : allQueryOperationTypes) {
            String rawType = queryOperationType.getType();
            if (type.equals(rawType)) {
                return queryOperationType;
            }
        }

        return null;
    }

    public static OrderOperationType parseOrderOperationType(String type) {
        OrderOperationType[] allOrderOperationTypes = OrderOperationType.values();

        for (OrderOperationType orderOperationType : allOrderOperationTypes) {
            String rawType = orderOperationType.getType();
            if (type.equals(rawType)) {
                return orderOperationType;
            }
        }
        return null;
    }

    public static UpdateOperationType parseUpdateOperationType(String type) {
        return UpdateOperationType.TITLE_MAP.get(type);
    }
}
