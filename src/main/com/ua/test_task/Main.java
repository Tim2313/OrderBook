package com.ua.test_task;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path filepath = Paths.get("/home/timatam/coding/TestTaskProxyBand/src/resources/input.txt");
        File file = filepath.toFile();
        Path fileOutputPath = Paths.get("/home/timatam/coding/TestTaskProxyBand/out/output.txt");
        File fileOutput = fileOutputPath.toFile();
        try (
                FileReader fr = new FileReader(file);
                FileWriter fw = new FileWriter(fileOutput);
                BufferedReader br = new BufferedReader(fr);

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

        String massageFormat = "Now im parsing line: %s.";
        String massage = String.format(massageFormat, line);
        System.out.println(massage);


        if (opera == 'u') {
            UpdateOperation updateOperation = new UpdateOperation(line);
        }

        if (opera == 'q') {
            System.out.println("Now we have a query.");
        }

        if (opera == 'o') {
            System.out.println("Now we have your order.");
        }
        System.out.println();
    }

}

