package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Order;
import br.com.alura.clientelo.reports.comparators.OrderQuantityComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TopThreeByQuantityReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(TopThreeByQuantityReport.class);

    @Override
    public void logReport(List<Order> orders) {
        if (orders == null) {
            logger.info("!!!!!FOI PASSADO UMA LISTA Nula!!!!!\n");
            return;
        }

        orders.sort(new OrderQuantityComparator());

        logger.info("##### RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE #####");
        for (int i = 1; i <= 3 && i <= orders.size(); i++) {
            logger.info("PRODUTO: {}", orders.get(orders.size() - i).getProduct());
            logger.info("QUANTIDADE {}\n", orders.get(orders.size() - i).getQuantity());
        }
    }
}
