package com.ua.test_task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Main {
     static Memory memory = new Memory();

    public static void main(String[] args) {
        Path filepath = Paths.get("/home/timatam/coding/TestTaskProxyBand/src/resources/input.txt");
        File file = filepath.toFile();
        Path fileOutputPath = Paths.get("/home/timatam/coding/TestTaskProxyBand/out/output.txt");
        File fileOutput = fileOutputPath.toFile();
        try (FileReader fr = new FileReader(file); FileWriter fw = new FileWriter(fileOutput); BufferedReader br = new BufferedReader(fr);

        ) {
            while (br.ready()) {
                String line = br.readLine();
                parseLine(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseLine(String line) {
        char opera = line.charAt(0);

        if (opera == 'u') {
            UpdateOperation updateOperation = new UpdateOperation(line);

            memory.saveAsk(updateOperation);
            memory.saveBid(updateOperation);

        }

        if (opera == 'q') {
            String[] splitline = line.split(",");
            if (splitline.length == 3) {
                QueryOperationByType queryOperationByType = new QueryOperationByType(line);

            } else {
                QueryOperationBest queryOperation = new QueryOperationBest(line);


            }
        }

        if (opera == 'o') {
            OrderOperation orderOperation = new OrderOperation(line);
        }
    }

}

