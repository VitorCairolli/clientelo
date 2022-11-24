package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.models.ProductItem;

import java.util.*;

public class ReportSortTools {

    public static Map<String, CategorySummary> categoriesSummaryMap(List<Order> orders){
        Map<String, CategorySummary> categorySummaryMap = new LinkedHashMap<>();

        orders.forEach(order -> {
            order.getProductItems().stream().sorted(Comparator.comparing(ProductItem::getProduct))
                    .forEach(productItem -> {
                        if(categorySummaryMap.containsKey(productItem.getProduct().getCategory().getName()))
                            categorySummaryMap.get(productItem.getProduct().getCategory().getName()).addOrderValues(productItem);
                        else
                            categorySummaryMap.put(productItem.getProduct().getCategory().getName(), new CategorySummary(productItem));
                    });
        });
        return categorySummaryMap;
    }

    public static Map<String, Order> mostValuableOrderPerCategoryMap(List<Order> orders){
        Map<String, Order> orderMap = new LinkedHashMap<>();
        Set<String> categories = new HashSet<>();

        for (Order order : orders){
            order.getProductItems().forEach(productItem ->
                    categories.add(productItem.getProduct().getCategory().getName()));
        }

        categories.forEach(category -> {
            List<Order> orderedOrderOfCategory = orders.stream()
                    .filter(order -> order.hasProductOfCategory(category))
                    .sorted(Comparator.comparing(Order::getTotalPrice).reversed())
                    .toList();

            orderMap.put(category, orderedOrderOfCategory.get(0));
        });

        return orderMap;
    }

    public static List<Order> topThreeOrdersByQuantity(List<Order> orders){
        List<Order> topThreeOrders = orders.stream().sorted(Comparator.comparing(Order::getTotalQuantity).reversed())
                .toList();

        if(topThreeOrders.size() > 3)
            return  topThreeOrders.subList(0,3);

        return topThreeOrders;
    }
}
