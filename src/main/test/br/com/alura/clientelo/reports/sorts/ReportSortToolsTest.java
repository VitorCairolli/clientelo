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
}