package br.com.alura.clientelo.reports.sorts;

import br.com.alura.clientelo.models.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReportSortToolsTest extends CsvProcessor {
    @Test
    void returnTopThreeOrdersByQuantity() {
        List<Order> topThreeOrdersByQuantity = ReportSortTools.topThreeOrdersByQuantity(orders);

        Order first = new Order(new ProductItem(new Product("iPhone 13 Pro",
                BigDecimal.valueOf(9176.00).setScale(2),
                "",6, new Category("CELULARES")),
                null,
                6,
                null),
                new Client("ANA",
                        "anaAgiota@gmail.com",
                        new Address("Rua Pinheiros Grandes",
                                "552",
                                "ap 52")),
                LocalDate.parse("13/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order second = new Order(new ProductItem(new Product("Monitor Dell 27",
                BigDecimal.valueOf(1889.00).setScale(2),
                "",3, new Category("INFORMÁTICA")),
                null,
                3,
                null),
                new Client("DANI",
                        "danista@gmail.com",
                        new Address("Rua DANIficada",
                                "57",
                                "nenhum")),
                LocalDate.parse("04-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Order third = new Order(new ProductItem(new Product("Implementing Domain-Driven Design",
                BigDecimal.valueOf(144.07).setScale(2),
                "",3, new Category("LIVROS")),
                null,
                3,
                null),
                new Client("GABI",
                        "gabinete@gmail.com",
                        new Address("Rua Casaco",
                                "12",
                                "nenhum")),
                LocalDate.parse("10-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Assert.assertEquals(topThreeOrdersByQuantity.get(0), first);
        Assert.assertEquals(topThreeOrdersByQuantity.get(1), second);
        Assert.assertEquals(topThreeOrdersByQuantity.get(2), third);
    }

    @Test
    void topThreeOrdersByQuantityReturnTwoOrders(){
        List<Order> twoOrders = ReportSortTools.topThreeOrdersByQuantity(orders.subList(0,2));

        Assert.assertEquals(twoOrders.size(), 2);
    }

    @Test
    void topThreeOrdersByQuantityReturnOneOrder(){
        List<Order> order = ReportSortTools.topThreeOrdersByQuantity(orders.subList(0,1));

        Assert.assertEquals(order.size(), 1);
    }

    @Test
    void returnMostValuablePerCategoryOrderedByCategory(){
        Map<String, Order> mostValuableMap= ReportSortTools.mostValuableOrderPerCategoryMap(orders);

        Order first = new Order(new ProductItem(new Product("Jogo de pneus",
                BigDecimal.valueOf(1276.79).setScale(2),
                "",1, new Category("AUTOMOTIVA")),
                null,
                1,
                null),
                new Client("BIA",
                        "bianca@hotmail.com",
                        new Address("Rua Biancaneira",
                                "781",
                                "nenhum")),
                LocalDate.parse("15/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order second = new Order(new ProductItem(new Product("iPhone 13 Pro",
                BigDecimal.valueOf(9176.00).setScale(2),
                "",6, new Category("CELULARES")),
                null,
                6,
                null),
                new Client("ANA",
                        "anaAgiota@gmail.com",
                        new Address("Rua Pinheiros Grandes",
                                "552",
                                "ap 52")),
                LocalDate.parse("13/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order third = new Order(new ProductItem(new Product("Macbook Pro 16",
                BigDecimal.valueOf(31752.00).setScale(2),
                "",1, new Category("INFORMÁTICA")),
                null,
                1,
                null),
                new Client("CAIO",
                        "caioNoBait@gmail.com",
                        new Address("Rua Tetriz",
                                "444",
                                "Moro na casa do fundo")),
                LocalDate.parse("03/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Order fourth = new Order(new ProductItem(new Product("Implementing Domain-Driven Design",
                BigDecimal.valueOf(144.07).setScale(2),
                "",3, new Category("LIVROS")),
                null,
                3,
                null),
                new Client("GABI",
                        "gabinete@gmail.com",
                        new Address("Rua Casaco",
                                "12",
                                "nenhum")),
                LocalDate.parse("10/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

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