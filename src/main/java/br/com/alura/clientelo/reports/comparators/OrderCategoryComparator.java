package br.com.alura.clientelo.reports.comparators;

import br.com.alura.clientelo.Order;

import java.util.Comparator;

public class OrderCategoryComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1 == null) return -1;
        if(o2 == null) return 1;
        return o1.getCategory().compareTo(o2.getCategory());
    }
}
