package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Order;
import br.com.alura.clientelo.reports.comparators.OrderCategoryComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MostValuableOrderedByCategoryReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(MostValuableOrderedByCategoryReport.class);

    @Override
    public void logReport(List<Order> orders) {
        if (orders == null) {
            logger.info("!!!!!FOI PASSADO UMA LISTA Nula!!!!!\n");
            return;
        }

        orders.sort(new OrderCategoryComparator());

        Order mostValuable = orders.get(0);

        logger.info("##### RELATÓRIO DE PEDIDOS MAIS VALIOSOS POR CATEGORIA EM ORDEM ALFABETICA #####");
        for (int i = 1; i < orders.size(); i++) {
            if (!(mostValuable.getCategory().equals(orders.get(i).getCategory())) || i == orders.size() - 1) {
                logger.info("CATEGORIA: {}", mostValuable.getCategory());
                logger.info("PRODUTO {}", mostValuable.getProduct());
                logger.info("PRECO {}\n", mostValuable.getPrice());
                mostValuable = orders.get(i);
            } else {
                if (mostValuable.getPrice().compareTo(orders.get(i).getPrice()) < 0)
                    mostValuable = orders.get(i);
            }
        }
    }
}
