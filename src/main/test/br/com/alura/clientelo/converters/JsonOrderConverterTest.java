package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.Order;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonOrderConverterTest extends ExpectedOrderList{

    @Test
    void convertShouldReturnListWithAllExpectedOrders(){
        List<Order> jsonOrders = JsonOrderConverter.convert("test/orders.json");

        for(Order order : jsonOrders) {
            boolean a = expectedOrders.contains(order);
            System.out.println(a + " " + order);
        }
//        csvOrders.forEach(order -> Assert.assertTrue(expectedOrders.contains(order)));
    }
}
