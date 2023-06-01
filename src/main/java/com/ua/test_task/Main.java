package com.ua.test_task;

import com.ua.test_task.service.*;

import static com.ua.test_task.constant.FileConstant.INPUT_DESTINATION;
import static com.ua.test_task.constant.FileConstant.OUTPUT_DESTINATION;

public class Main {

    private static final Memory MEMORY = new Memory();
    private static final WritterService WRITTER_SERVICE = new WritterService(OUTPUT_DESTINATION);
    private static final ReaderService READER_SERVICE = new ReaderService(INPUT_DESTINATION);
    private static final OperationTypeProcessor OPERATION_TYPE_PROCESSOR = new OperationTypeProcessor(MEMORY, WRITTER_SERVICE);

    public static void main(String[] args) {

        while (READER_SERVICE.ready()) {
            String line = READER_SERVICE.read();
            OPERATION_TYPE_PROCESSOR.process(line);
        }

        WRITTER_SERVICE.close();
        READER_SERVICE.close();
    }
}

