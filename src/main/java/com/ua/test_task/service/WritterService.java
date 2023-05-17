package com.ua.test_task.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritterService {

    private final FileWriter fileWriter;

    public WritterService(String outputDestination) {
        Path fileOutputPath = Paths.get(outputDestination);
        File fileOutput = fileOutputPath.toFile();

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.fileWriter = fileWriter;
    }

    public void write(String message) {
        try {
            fileWriter.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

