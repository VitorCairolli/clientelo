package br.com.alura.clientelo.reports.comparators;
import br.com.alura.clientelo.reports.tools.OrderCategorySummary;

import java.util.Comparator;

public class CategorySummaryCategoryComparator implements Comparator<OrderCategorySummary> {

    @Override
    public int compare(OrderCategorySummary o1, OrderCategorySummary o2) {
        if(o1==null) return -1;
        if(o2==null) return 1;
        return o1.getCategory().compareTo(o2.getCategory());
    }
}
