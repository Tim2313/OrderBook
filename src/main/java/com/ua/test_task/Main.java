package com.ua.test_task;

import com.ua.test_task.model.*;
import com.ua.test_task.service.Memory;
import com.ua.test_task.service.OperationInitializationService;
import com.ua.test_task.service.UpdateOperationComparatorMax;
import com.ua.test_task.service.UpdateOperationComparatorMin;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    static Memory memory = new Memory();

    public static void main(String[] args) {
        Path filepath = Paths.get("input.txt");
        File file = filepath.toFile();
        Path fileOutputPath = Paths.get("output.txt");
        File fileOutput = fileOutputPath.toFile();
        try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(fileOutput); BufferedReader br = new BufferedReader(fr);

        ) {
            while (br.ready()) {
                String line = br.readLine();
                parseLine(line, fw);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseLine(String line, FileWriter fw) throws IOException {
        char operation = line.charAt(0);
        OperationType operationType = OperationInitializationService.parseOperationType(operation);
        if (operationType == OperationType.UpdateOperation) {
            UpdateOperation updateOperation = OperationInitializationService.createUpdateOperation(line);
            if (updateOperation.getType().equals("ask")) {
                memory.saveAsk(updateOperation);
            }
            if (updateOperation.getType().equals("bid")) {
                memory.saveBid(updateOperation);
            }

        }

        if (operationType == OperationType.QueryOperation) {
            String[] splitline = line.split(",");
            if (splitline.length == 3) {
                QueryOperationByType queryOperationByType = OperationInitializationService.createQueryOperationByType(line);
                if (queryOperationByType.getType().equals("size")) {
                    int size = memory.getByPriceBid(queryOperationByType.getValue());
                    int price = queryOperationByType.getValue();
                    String formatMassage = "For price:%d the size is: %d.\n";
                    String massage = String.format(formatMassage, price, size);
                    fw.write(massage);
                }
            } else {
                QueryOperationBest queryOperationBest = OperationInitializationService.createQueryOperationBest(line);
                if (queryOperationBest.getType().equals("best_bid")) {
                    List<UpdateOperation> bids = memory.getBids();
                    UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
                    int price = max.getPrice();
                    int size = max.getSize();
                    String formatMassage = "Best_bid:\nprice: %d, size: %d\n";
                    String massage = String.format(formatMassage, price, size);
                    fw.write(massage);

                }
                if (queryOperationBest.getType().equals("best_ask")) {
                    List<UpdateOperation> asks = memory.getAsks();

                    UpdateOperation max = Collections.max(asks, new UpdateOperationComparatorMax());
                    int price = max.getPrice();
                    int size = max.getSize();
                    String formatMassage = "Best_ask:\nprice: %d, size: %d\n";
                    String massage = String.format(formatMassage, price, size);
                    fw.write(massage);
                }

            }
        }

        if (operationType == OperationType.OrderOperation) {
            OrderOperation orderOperation = OperationInitializationService.createOrderOperation(line);
            if (orderOperation.getType().equals("sell")) {
                List<UpdateOperation> bids = memory.getBids();

                UpdateOperation max = Collections.max(bids, new UpdateOperationComparatorMax());
                int price = max.getPrice();
                int size = max.getSize() - orderOperation.getSize();
                max.setSize(size);
                int orderSize = orderOperation.getSize();
                String typeOfOrder = orderOperation.getType();
                String orderFormat = "After order - %s - %d, we have bid: %d %d\n";
                String orderMassage = String.format(orderFormat, typeOfOrder, orderSize, price, size);
                fw.write(orderMassage);
            }
            if (orderOperation.getType().equals("buy")) {
                List<UpdateOperation> ask = memory.getBids();

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
                fw.write(orderMassage);

            }
        }

    }
}

