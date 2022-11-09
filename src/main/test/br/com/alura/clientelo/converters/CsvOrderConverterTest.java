package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.Order;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CsvOrderConverterTest{

    @Test
    void convertShouldReturnListWithEightOrders() {
        List<Order> csvOrders = CsvOrderConverter.convert("test/orders.csv");

        Assert.assertEquals(csvOrders.size(), 7);
    }

    @Test
    void convertShouldThrowFileNotFoundExceptionWhenFileNotFound(){
        Assert.assertThrows(RuntimeException.class, () ->CsvOrderConverter.convert("test/orders.throw"));
    }
}