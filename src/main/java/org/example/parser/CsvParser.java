package org.example.parser;

import org.example.Application;
import org.example.model.Order;
import org.example.model.OrderCreator;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class CsvParser implements Parser{

    private String path;

    public CsvParser() {
    }

    public CsvParser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void parse(BufferedReader bufferedReader) throws InterruptedException, IOException {
        String line;
        int lineCounter = 1;

        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            Order order = OrderCreator.createOrderByValues(values);

            order.setLine(lineCounter);
            order.setFilename(path);
            Application.QUEUE.put(order);

            lineCounter++;
        }
    }
}
