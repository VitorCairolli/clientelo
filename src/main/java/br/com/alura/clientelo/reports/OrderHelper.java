package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Main;
import br.com.alura.clientelo.Order;
import br.com.alura.clientelo.reports.comparators.CategorySummaryCategoryComparator;
import br.com.alura.clientelo.reports.comparators.OrderCategoryComparator;
import br.com.alura.clientelo.reports.tools.OrderCategorySummary;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHelper {
    protected static List<OrderCategorySummary> categorySummaryList(List<Order> orders) {

        orders.sort(new OrderCategoryComparator());
        Map<String, OrderCategorySummary> map = new HashMap<>();

        for(Order order : orders) {
            if(!map.containsKey(order.getCategory()))
                map.put(order.getCategory(),
                        new OrderCategorySummary(
                                order.getCategory(),
                                order.getQuantity(),
                                order.getTotalPrice()
                        ));
            else map.get(order.getCategory()).addValues(order.getQuantity(), order.getTotalPrice());
        }

        List<OrderCategorySummary> categorySummaryList = new ArrayList<>(map.values().stream().toList());
        categorySummaryList.sort(new CategorySummaryCategoryComparator());
        return categorySummaryList;
    }
}

