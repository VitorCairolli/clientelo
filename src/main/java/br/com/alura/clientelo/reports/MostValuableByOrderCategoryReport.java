package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.daos.OrderDao;
import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.output.OrderReportOutput;
import br.com.alura.clientelo.reports.output.Output;
import br.com.alura.clientelo.reports.sorts.ReportSortTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MostValuableByOrderCategoryReport implements Report{

    @Override
    public void logReport() {

        OrderDao orderDao = new OrderDao();
        List<Order> orders = orderDao.findAll();

        List<Output> report = new ArrayList<>();

        Map<String, Order> mostValuableOrders = ReportSortTools.mostValuableOrderPerCategoryMap(orders);

        mostValuableOrders.forEach((category, order) -> {
            report.add(OrderReportOutput.Builder.newInstance()
                    .setOrderId(order.getId())
                    .setCategory(category)
                    .setProductItem(order.getProductItems())
                    .setTotalPrice(order.getTotalPrice())
                    .build());
        });

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title(){
        return "RELATÓRIO DE PEDIDOS MAIS VALIOSOS POR CATEGORIA EM ORDEM ALFABETICA";
    }
}
