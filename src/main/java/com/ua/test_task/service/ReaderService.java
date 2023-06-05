package com.ua.test_task.service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderService {

    private final BufferedReader bufferedReader;

    public ReaderService(String fileToRead) {
        Path filepath = Paths.get(fileToRead);
        File file = filepath.toFile();

        FileReader fileReader;
        BufferedReader buffReader;
        try {
            fileReader = new FileReader(file);
            buffReader = new BufferedReader(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.bufferedReader = buffReader;
    }

    public String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean ready() {
        try {
            return bufferedReader.ready();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
