package org.example.out;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Application;
import org.example.model.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class OutputConverter {

    public void convertToJson() {
        Gson gson = new GsonBuilder().create();

        while (true) {
            try {
                Order order = Application.QUEUE.poll(100, TimeUnit.MILLISECONDS);

                if (order == null) {
                    break;
                }

                String jsonObject = gson.toJson(order);
                System.out.println(jsonObject);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
