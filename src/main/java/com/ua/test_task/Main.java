package com.ua.test_task;

import com.ua.test_task.model.*;
import com.ua.test_task.service.*;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMax;
import com.ua.test_task.service.comparator.UpdateOperationComparatorMin;

import java.util.*;

import static com.ua.test_task.constant.FileConstant.INPUT_DESTINATION;
import static com.ua.test_task.constant.FileConstant.OUTPUT_DESTINATION;

public class Main {

    private static final Memory MEMORY = new Memory();
    private static final WritterService WRITTER_SERVICE = new WritterService(OUTPUT_DESTINATION);
    private static final ReaderService READER_SERVICE = new ReaderService(INPUT_DESTINATION);
    private static final UpdateOperationService updateOperationService = new UpdateOperationService(MEMORY);

    public static void main(String[] args) {

        while (READER_SERVICE.ready()) {
            String line = READER_SERVICE.read();
            parseLine(line);
        }

        WRITTER_SERVICE.close();
        READER_SERVICE.close();
    }

    private static void parseLine(String line) {

        char operation = line.charAt(0);
        OperationType operationType = OperationInitializationService.parseOperationType(operation);
        if (operationType == OperationType.UpdateOperation) {
            UpdateOperation updateOperation = OperationInitializationService.createUpdateOperation(line);
            updateOperationService.execute(updateOperation);
        }

        if (operationType == OperationType.QueryOperation) {
            String[] splitline = line.split(",");
            if (splitline.length == 3) {
                QueryOperationByType queryOperationByType = OperationInitializationService.createQueryOperationByType(line);
                if (queryOperationByType.getType().equals("size")) {
                    int size = MEMORY.getByPriceBid(queryOperationByType.getValue());
                    int price = queryOperationByType.getValue();
                    String formatMassage = "For price:%d the size is: %d.\n";
                    String massage = String.format(formatMassage, price, size);
                    WRITTER_SERVICE.write(massage);
                }
            } else {
                QueryOperationBest queryOperationBest = OperationInitializationService.createQueryOperationBest(line);
                if (queryOperationBest.getType().equals("best_bid")) {
                    List<UpdateOperation> bids = MEMORY.getBids();
                    UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
                    int price = max.getPrice();
                    int size = max.getSize();
                    String formatMassage = "Best_bid:\nprice: %d, size: %d\n";
                    String massage = String.format(formatMassage, price, size);
                    WRITTER_SERVICE.write(massage);

                }
                if (queryOperationBest.getType().equals("best_ask")) {
                    List<UpdateOperation> asks = MEMORY.getAsks();

                    UpdateOperation max = Collections.max(asks, new UpdateOperationComparatorMax());
                    int price = max.getPrice();
                    int size = max.getSize();
                    String formatMassage = "Best_ask:\nprice: %d, size: %d\n";
                    String massage = String.format(formatMassage, price, size);
                    WRITTER_SERVICE.write(massage);
                }

            }
        }

        if (operationType == OperationType.OrderOperation) {
            OrderOperation orderOperation = OperationInitializationService.createOrderOperation(line);
            if (orderOperation.getType().equals("sell")) {
                List<UpdateOperation> bids = MEMORY.getBids();

                UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
                int price = max.getPrice();
                int size = max.getSize() - orderOperation.getSize();
                max.setSize(size);
                int orderSize = orderOperation.getSize();
                String typeOfOrder = orderOperation.getType();
                String orderFormat = "After order - %s - %d, we have bid: %d %d\n";
                String orderMassage = String.format(orderFormat, typeOfOrder, orderSize, price, size);
                WRITTER_SERVICE.write(orderMassage);
            }
            if (orderOperation.getType().equals("buy")) {
                List<UpdateOperation> ask = MEMORY.getBids();

                UpdateOperation min = Collections.max(ask, new UpdateOperationComparatorMin());
                int price = min.getPrice();
                int size = min.getSize() + orderOperation.getSize();
                min.setSize(size);
                // CRUD
                // Create Read Update Delete
                // Update = delete + create
                int orderSize = orderOperation.getSize();
                String typeOfOrder = orderOperation.getType();
                String orderFormat = "After order - %s - %d, we have bid: %d %d\n";
                String orderMassage = String.format(orderFormat, typeOfOrder, orderSize, price, size);
                WRITTER_SERVICE.write(orderMassage);
            }
        }
    }
}

