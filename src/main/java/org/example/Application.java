package org.example;

import org.example.config.Config;
import org.example.handler.FileHandler;
import org.example.handler.FileHandlerV1;
import org.example.model.*;
import org.example.out.OutputConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.*;

public class Application {
    public static BlockingQueue<Order> QUEUE = new ArrayBlockingQueue<>(1000);
    public static int ORDER_ID = 0;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        FileHandler fileHandler = context.getBean("fileHandlerV1", FileHandlerV1.class);
        fileHandler.setArgs(args);

        OutputConverter converter = context.getBean("outputConverter", OutputConverter.class);


        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(fileHandler::convert);
        executorService.submit(converter::convertToJson);

        executorService.shutdown();
    }

}
