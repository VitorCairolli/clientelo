package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Order;
import br.com.alura.clientelo.reports.tools.OrderCategorySummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class OrderByCategoryReport implements Report {

    private static final Logger logger = LoggerFactory.getLogger(OrderByCategoryReport.class);

    @Override
    public void logReport(List<Order> orders) {
        if (orders == null) {
            logger.info("!!!!!FOI PASSADO UMA LISTA Nula!!!!!\n");
            return;
        }

        List<OrderCategorySummary> categorySummaryList = OrderHelper.categorySummaryList(orders);

        logger.info("##### RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE #####");
        for (OrderCategorySummary summary : categorySummaryList) {
            logger.info("CATEGORIA: {}", summary.getCategory());
            logger.info("QUANTIDADE {}\n", summary.getQuantity());
            logger.info("MONTANTE: R$ {}\n", summary.getTotalPrice());
        }
    }
}
