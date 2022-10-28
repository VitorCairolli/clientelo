package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.Address;
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

        Order first = new Order("CELULARES",
                "iPhone 13 Pro",
                new Client("ANA",
                        "anaAgiota@gmail.com",
                        new Address("Rua Pinheiros Grandes",
                                "552",
                                "ap 52")),
                BigDecimal.valueOf(9176.00).setScale(2),
                6,
                LocalDate.parse("13/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order second = new Order("CELULARES",
                "Galaxy S22 Ultra",
                new Client("DANI",
                        "danista@gmail.com",
                        new Address("Rua DANIficada",
                                "57",
                                "nenhum")),
                BigDecimal.valueOf(8549.10).setScale(2),
                5,
                LocalDate.parse("14/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order third = new Order("INFORMÁTICA",
                "Galaxy Tab S8",
                new Client("BIA",
                        "bianca@hotmail.com",
                        new Address("Rua Biancaneira",
                                "781",
                                "nenhum")),
                BigDecimal.valueOf(5939.10).setScale(2),
                4,
                LocalDate.parse("02/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

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

        Order first = new Order("AUTOMOTIVA",
                "Jogo de pneus",
                new Client("BIA",
                        "bianca@hotmail.com",
                        new Address("Rua Biancaneira",
                                "781",
                                "nenhum")),
                BigDecimal.valueOf(1276.79).setScale(2),
                1,
                LocalDate.parse("15/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order second = new Order("CELULARES",
                "iPhone 13 Pro",
                new Client("ANA",
                        "anaAgiota@gmail.com",
                        new Address("Rua Pinheiros Grandes",
                                "552",
                                "ap 52")),
                BigDecimal.valueOf(9176.00).setScale(2),
                6,
                LocalDate.parse("13/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order third = new Order("INFORMÁTICA",
                "Macbook Pro 16",
                new Client("CAIO",
                        "caioNoBait@gmail.com",
                        new Address("Rua Tetriz",
                                "444",
                                "Moro na casa do fundo")),
                BigDecimal.valueOf(31752.00).setScale(2),
                1,
                LocalDate.parse("03/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order fourth = new Order("LIVROS",
                "Building Microservices",
                new Client("CAIO",
                        "caioNoBait@gmail.com",
                        new Address("Rua Tetriz",
                                "444",
                                "Moro na casa do fundo")),
                BigDecimal.valueOf(300.28).setScale(2),
                2,
                LocalDate.parse("11/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order fifth = new Order("MÓVEIS",
                "Cama queen size",
                new Client("DANI",
                        "danista@gmail.com",
                        new Address("Rua DANIficada",
                                "57",
                                "nenhum")),
                BigDecimal.valueOf(3100.00).setScale(2),
                2,
                LocalDate.parse("07/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Assert.assertEquals(mostValuableMap.get("AUTOMOTIVA"), first);
        Assert.assertEquals(mostValuableMap.get("CELULARES"), second);
        Assert.assertEquals(mostValuableMap.get("INFORMÁTICA"), third);
        Assert.assertEquals(mostValuableMap.get("LIVROS"), fourth);
        Assert.assertEquals(mostValuableMap.get("MÓVEIS"), fifth);
    }
    @Test
    void returnCategorySummaryMapOfEachCategoryOrderedByCategory(){
        Map<String, CategorySummary> categorySummaryMap = ReportSortTools.categoriesSummaryMap(orders);

        Assert.assertTrue(categorySummaryMap.containsKey("AUTOMOTIVA"));
        Assert.assertEquals(BigDecimal.valueOf(1987.97).setScale(2), categorySummaryMap.get("AUTOMOTIVA").getPrice());
        Assert.assertEquals(2, categorySummaryMap.get("AUTOMOTIVA").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("CELULARES"));
        Assert.assertEquals(BigDecimal.valueOf(97801.50).setScale(2), categorySummaryMap.get("CELULARES").getPrice());
        Assert.assertEquals(11, categorySummaryMap.get("CELULARES").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("INFORMÁTICA"));
        Assert.assertEquals(BigDecimal.valueOf(64698.40).setScale(2), categorySummaryMap.get("INFORMÁTICA").getPrice());
        Assert.assertEquals(9, categorySummaryMap.get("INFORMÁTICA").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("LIVROS"));
        Assert.assertEquals(BigDecimal.valueOf(1507.64).setScale(2), categorySummaryMap.get("LIVROS").getPrice());
        Assert.assertEquals(9, categorySummaryMap.get("LIVROS").getQuantity());
        Assert.assertTrue(categorySummaryMap.containsKey("MÓVEIS"));
        Assert.assertEquals(BigDecimal.valueOf(12378.98).setScale(2), categorySummaryMap.get("MÓVEIS").getPrice());
        Assert.assertEquals(4, categorySummaryMap.get("MÓVEIS").getQuantity());
    }
}