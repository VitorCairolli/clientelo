package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.converters.CsvOrderConverter;
import br.com.alura.clientelo.models.Order;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {

    List<Order> orders = new ArrayList<>();

    @BeforeEach
    void setupOrderList(){
        String csvPath = "./test/orders.csv";
        orders = CsvOrderConverter.convert(csvPath);
    }
}
