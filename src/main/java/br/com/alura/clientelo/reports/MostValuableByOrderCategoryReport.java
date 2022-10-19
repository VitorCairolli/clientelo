package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.models.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MostValuableByOrderCategoryReport implements Report{

    @Override
    public void logReport(List<Order> orders) {

        orders.sort(Comparator.comparing(Order::getCategory));
        List<String> categories = orders.stream()
                .map(order -> order.getCategory())
                .distinct()
                .toList();

        List<OrderReportOutput> report = new ArrayList<>();

        for (String category : categories) {
            orders.stream()
                    .filter(order -> order.getCategory().equals(category))
                    .toList();

            report.add(OrderReportOutput.Builder
                    .newInstance()
                    .setCategory(category)
                    .setProduct(orders.get(0).getProduct())
                    .setTotalPrice(orders.get(0).getTotalPrice())
                    .build());
        }

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title(){
        return "RELATÓRIO DE PEDIDOS MAIS VALIOSOS POR CATEGORIA EM ORDEM ALFABETICA";
    }
}
