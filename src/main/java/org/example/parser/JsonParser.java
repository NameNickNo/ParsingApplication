package org.example.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Application;
import org.example.model.Order;
import org.example.model.ResultParsing;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Component
public class JsonParser implements Parser{
    private String path;

    public JsonParser() {
    }

    public JsonParser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void parse(BufferedReader bufferedReader) throws InterruptedException, IOException {

        Gson gson = new GsonBuilder().create();
        List<Order> jsonOrders = gson.fromJson(bufferedReader, new TypeToken<List<Order>>() {
        }.getType());

        for (Order order : jsonOrders) {
            order.setLine((jsonOrders.indexOf(order)) + 1);
            order.setFilename(path);
            order.setOrderId(++Application.ORDER_ID);
            order.setResult(ResultParsing.OK);
            Application.QUEUE.put(order);
        }

    }
}
