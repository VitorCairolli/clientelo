package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

public class TopThreeOrdersByQuantityReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(TopThreeOrdersByQuantityReport.class);

    @Override
    public void logReport(List<Order> orders) {

        orders.sort(Comparator.comparing(Order::getQuantity));

        for (int i = 1; i <= 3 && i <= orders.size(); i++) {
            logger.info("PRODUTO: {}", orders.get(orders.size() - i).getProduct());
            logger.info("QUANTIDADE {}\n", orders.get(orders.size() - i).getQuantity());
        }
    }

    @Override
    public String title() {
        return "RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE";
    }
}
