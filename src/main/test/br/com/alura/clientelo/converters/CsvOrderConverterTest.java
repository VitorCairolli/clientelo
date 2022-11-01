package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.Order;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CsvOrderConverterTest extends ExpectedOrderList {

    @Test
    void convertShouldReturnListWithAllExpectedOrders() {
        List<Order> csvOrders = CsvOrderConverter.convert("test/orders.csv");

        csvOrders.forEach(order -> Assert.assertTrue(expectedOrders.contains(order)));
    }
}