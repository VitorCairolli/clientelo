package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.output.OrderReportOutput;
import br.com.alura.clientelo.reports.output.Output;
import br.com.alura.clientelo.reports.sorts.ReportSortTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TopThreeOrdersByQuantityReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(TopThreeOrdersByQuantityReport.class);

    @Override
    public void logReport() {

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.findAll();

        List<Output> report = new ArrayList<>();

        List<Order> topThreeOrders = ReportSortTools.topThreeOrdersByQuantity(orders);

        for (Order order : topThreeOrders) {

            report.add(OrderReportOutput.Builder.newInstance()
                    .setOrderId(order.getId())
                    .setProductItem(order.getProductItems())
                    .setQuantity(BigDecimal.valueOf(order.getTotalQuantity()))
                    .build());
        }

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title() {
        return "RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE";
    }
}
