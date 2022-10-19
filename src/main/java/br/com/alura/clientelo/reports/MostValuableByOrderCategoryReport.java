package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

public class MostValuableByOrderCategoryReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(MostValuableByOrderCategoryReport.class);

    @Override
    public void logReport(List<Order> orders) {

        orders.sort(Comparator.comparing(Order::getCategory));
        List<String> categories = orders.stream()
                .map(order -> order.getCategory())
                .distinct()
                .toList();

        for (String category : categories) {
            orders.stream()
                    .filter(order -> order.getCategory().equals(category))
                    .toList();

            logger.info("CATEGORIA: {}", category);
            logger.info("PRODUTO {}", orders.get(0).getProduct());
            logger.info("PRECO: R$ {}\n", orders.get(0).getTotalPrice());
        }
    }

    @Override
    public String title(){
        return "RELATÓRIO DE PEDIDOS MAIS VALIOSOS POR CATEGORIA EM ORDEM ALFABETICA";
    }
}
