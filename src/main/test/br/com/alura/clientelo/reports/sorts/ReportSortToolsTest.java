package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.Address;
import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ReportSortToolsTest extends CsvProcessor {
    @Test
    void returnTopThreeOrdersByQuantity() {
        List<Order> topThreeOrdersByQuantity = ReportSortTools.topThreeOrdersByQuantity(orders);

        Order first = new Order(new Category("CELULARES"),
                "iPhone 13 Pro",
                new Client("ANA",
                        "anaAgiota@gmail.com",
                        new Address("Rua Pinheiros Grandes",
                                "552",
                                "ap 52")),
                BigDecimal.valueOf(9176.00).setScale(2),
                6,
                LocalDate.parse("13/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order second = new Order(new Category("INFORMÁTICA"),
                "Monitor Dell 27",
                new Client("DANI",
                        "danista@gmail.com",
                        new Address("Rua DANIficada",
                                "57",
                                "nenhum")),
                BigDecimal.valueOf(1889.00).setScale(2),
                3,
                LocalDate.parse("04-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Order third = new Order(new Category("LIVROS"),
                "Implementing Domain-Driven Design",
                new Client("GABI",
                        "gabinete@gmail.com",
                        new Address("Rua Casaco",
                                "12",
                                "nenhum")),
                BigDecimal.valueOf(144.07).setScale(2),
                3,
                LocalDate.parse("10-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Assert.assertEquals(topThreeOrdersByQuantity.get(0), first);
        Assert.assertEquals(topThreeOrdersByQuantity.get(1), second);
        Assert.assertEquals(topThreeOrdersByQuantity.get(2), third);
    }

    @Test
    void topThreOrdersByQuantityReturnTwoOrders(){
        List<Order> twoOrders = ReportSortTools.topThreeOrdersByQuantity(orders.subList(0,2));

        Assert.assertEquals(twoOrders.size(), 2);
    }

    @Test
    void topThreOrdersByQuantityReturnOneOrder(){
        List<Order> Order = ReportSortTools.topThreeOrdersByQuantity(orders.subList(0,1));

        Assert.assertEquals(Order.size(), 1);
    }

    @Test
    void returnMostValuablePerCategoryOrderedByCategory(){
        Map<String, Order> mostValuableMap= ReportSortTools.mostValuableOrderPerCategoryMap(orders);

        Order first = new Order(new Category("AUTOMOTIVA"),
                "Jogo de pneus",
                new Client("BIA",
                        "bianca@hotmail.com",
                        new Address("Rua Biancaneira",
                                "781",
                                "nenhum")),
                BigDecimal.valueOf(1276.79).setScale(2),
                1,
                LocalDate.parse("15/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order second = new Order(new Category("CELULARES"),
                "iPhone 13 Pro",
                new Client("ANA",
                        "anaAgiota@gmail.com",
                        new Address("Rua Pinheiros Grandes",
                                "552",
                                "ap 52")),
                BigDecimal.valueOf(9176.00).setScale(2),
                6,
                LocalDate.parse("13/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order third = new Order(new Category("INFORMÁTICA"),
                "Macbook Pro 16",
                new Client("CAIO",
                        "caioNoBait@gmail.com",
                        new Address("Rua Tetriz",
                                "444",
                                "Moro na casa do fundo")),
                BigDecimal.valueOf(31752.00).setScale(2),
                1,
                LocalDate.parse("03/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order fourth = new Order(new Category("LIVROS"),
                "Implementing Domain-Driven Design",
                new Client("GABI",
                        "gabinete@gmail.com",
                        new Address("Rua Casaco",
                                "12",
                                "nenhum")),
                BigDecimal.valueOf(144.07).setScale(2),
                3,
                LocalDate.parse("10-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Assert.assertEquals(mostValuableMap.get("AUTOMOTIVA"), first);
        Assert.assertEquals(mostValuableMap.get("CELULARES"), second);
        Assert.assertEquals(mostValuableMap.get("INFORMÁTICA"), third);
        Assert.assertEquals(mostValuableMap.get("LIVROS"), fourth);
    }
    @Test
    void returnCategorySummaryMapOfEachCategoryOrderedByCategory(){
        Map<String, CategorySummary> categorySummaryMap = ReportSortTools.categoriesSummaryMap(orders);

        Assert.assertTrue(categorySummaryMap.containsKey("AUTOMOTIVA"));
        Assert.assertEquals(BigDecimal.valueOf(1276.79).setScale(2), categorySummaryMap.get("AUTOMOTIVA").getPrice());
        Assert.assertEquals(1, categorySummaryMap.get("AUTOMOTIVA").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("CELULARES"));
        Assert.assertEquals(BigDecimal.valueOf(55056.00).setScale(2), categorySummaryMap.get("CELULARES").getPrice());
        Assert.assertEquals(6, categorySummaryMap.get("CELULARES").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("INFORMÁTICA"));
        Assert.assertEquals(BigDecimal.valueOf(37419.00).setScale(2), categorySummaryMap.get("INFORMÁTICA").getPrice());
        Assert.assertEquals(4, categorySummaryMap.get("INFORMÁTICA").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("LIVROS"));
        Assert.assertEquals(BigDecimal.valueOf(733.18).setScale(2), categorySummaryMap.get("LIVROS").getPrice());
        Assert.assertEquals(6, categorySummaryMap.get("LIVROS").getQuantity());
    }
}