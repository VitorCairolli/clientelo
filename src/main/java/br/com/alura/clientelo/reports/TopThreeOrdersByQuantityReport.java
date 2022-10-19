package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopThreeOrdersByQuantityReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(TopThreeOrdersByQuantityReport.class);

    @Override
    public void logReport(List<Order> orders) {

        orders.sort(Comparator.comparing(Order::getQuantity));

        List<OrderReportOutput> report = new ArrayList<>();

        for (int i = 1; i <= 3 && i <= orders.size(); i++) {

            report.add(OrderReportOutput.Builder.newInstance()
                    .setProduct(orders.get(orders.size() - i).getProduct())
                    .setQuantity(BigDecimal.valueOf(orders.get(orders.size() - i).getQuantity()))
                    .build());
        }

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title() {
        return "RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE";
    }
}
