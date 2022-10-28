package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.Order;

import java.util.*;

public class ReportSortTools {

    public static Map<String, CategorySummary> categoriesSummaryMap(List<Order> orders){
        Map<String, CategorySummary> categorySummaryMap = new LinkedHashMap<>();

        orders.stream().sorted(Comparator.comparing(Order::getCategory))
                .forEach(order -> {
                    if(categorySummaryMap.containsKey(order.getCategory()))
                        categorySummaryMap.get(order.getCategory()).addOrderValues(order);
                    else
                        categorySummaryMap.put(order.getCategory(), new CategorySummary(order));
                });
        return categorySummaryMap;
    }

    public static Map<String, Order> mostValuableOrderPerCategoryMap(List<Order> orders){
        List<String> categories = orders.stream()
                .map(order -> order.getCategory())
                .distinct()
                .sorted()
                .toList();

        Map<String, Order> orderMap = new LinkedHashMap<>();

        categories.forEach(category -> {
            List<Order> orderedOrderOfCategory = orders.stream()
                    .filter(order -> order.getCategory().equals(category))
                    .sorted(Comparator.comparing(Order::getTotalPrice).reversed())
                    .toList();

            orderMap.put(category, orderedOrderOfCategory.get(0));
        });

        return orderMap;
    }

    public static List<Order> topThreeOrdersByQuantity(List<Order> orders){
        return orders.stream().sorted(Comparator.comparing(Order::getQuantity).reversed())
                .toList()
                .subList(0,3);
    }
}
