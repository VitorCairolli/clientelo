package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class OrderCategoryReport implements Report {

    private static final Logger logger = LoggerFactory.getLogger(OrderCategoryReport.class);

    @Override
    public void logReport(List<Order> orders) {

        orders.sort(Comparator.comparing(Order::getCategory));
        List<String> categories = orders.stream()
                .map(order -> order.getCategory())
                .distinct()
                .toList();

        for (String category : categories) {
            BigDecimal totalQuantity = orders.stream()
                    .filter(order -> order.getCategory().equals(category))
                    .map(order -> new BigDecimal(order.getQuantity()))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal totalPrice = orders.stream()
                    .filter(order -> order.getCategory().equals(category))
                    .map(order -> order.getTotalPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            logger.info("CATEGORIA: {}", category);
            logger.info("QUANTIDADE {}", totalQuantity);
            logger.info("MONTANTE: R$ {}\n", totalPrice);
        }
    }

    @Override
    public String title(){
        return "RELATÓRIO POR CATEGORIAS";
    }
}
