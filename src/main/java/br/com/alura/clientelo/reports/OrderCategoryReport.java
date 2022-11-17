package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.output.OrderReportOutput;
import br.com.alura.clientelo.reports.output.Output;
import br.com.alura.clientelo.reports.sorts.ReportSortTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

public class OrderCategoryReport implements Report {

    private static final Logger logger = LoggerFactory.getLogger(OrderCategoryReport.class);
    @Override
    public void logReport() {

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.findAll();

        List<Output> report = new ArrayList<>();

        ReportSortTools.categoriesSummaryMap(orders).forEach(((category, summary) -> {
                report.add(OrderReportOutput.Builder.newInstance()
                        .setCategory(category)
                        .setQuantity(BigDecimal.valueOf(summary.getQuantity()))
                        .setTotalPrice(summary.getPrice())
                        .build());
        }));

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title(){
        return "RELATÓRIO POR CATEGORIAS";
    }
}
