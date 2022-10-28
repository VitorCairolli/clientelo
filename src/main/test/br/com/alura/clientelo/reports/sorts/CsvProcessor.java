package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.ProcessadorDeCsv;
import br.com.alura.clientelo.models.Order;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CsvProcessor {

    List<Order> orders = new ArrayList<>();

    @BeforeEach
    void setupOrderList(){
        String csvPath = "./test/orders.csv";
        orders = ProcessadorDeCsv.processaArquivo(csvPath);
    }
}
