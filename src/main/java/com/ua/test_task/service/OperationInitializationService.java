package com.ua.test_task.service;

import com.ua.test_task.model.*;

import java.util.Arrays;
import java.util.List;

public class OperationInitializationService {
    public static UpdateOperation createUpdateOperation(String line) {
        String[] splitString = line.split(",");
        int price = Integer.parseInt(splitString[1]);
        int size = Integer.parseInt(splitString[2]);
        String type = splitString[3];
        return new UpdateOperation(price, size, type);
    }

    public static QueryOperationBest createQueryOperationBest(String line) {
        String[] splitString = line.split(",");
        String type = splitString[1];
        return new QueryOperationBest(type);
    }

    public static OrderOperation createOrderOperation(String line) {
        String[] splitString = line.split(",");
        String type = splitString[1];
        int size = Integer.parseInt(splitString[2]);
        return new OrderOperation(type, size);
    }

    public static QueryOperationByType createQueryOperationByType(String line) {
        String[] splitString = line.split(",");
        String type = splitString[1];
        int value = Integer.parseInt(splitString[2]);
        return new QueryOperationByType(type, value);
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
}
