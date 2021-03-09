package org.example.model;

import org.example.Application;
import org.springframework.stereotype.Component;

@Component
public class OrderCreator {

    public OrderCreator() {
    }

    public static Order createOrderByValues(String[] values) {
        Order order = new Order();

        order.setResult(ResultParsing.OK);

        try {
            order.setAmount(Double.parseDouble(values[1]));
        } catch (NumberFormatException e) {
            order.setAmount(0.0);
            order.setResult(ResultParsing.NOT_CORRECT);
        }

        order.setCurrency(values[2]);
        order.setComment(values[3]);
        order.setOrderId(++Application.ORDER_ID);
        return order;
    }
}
