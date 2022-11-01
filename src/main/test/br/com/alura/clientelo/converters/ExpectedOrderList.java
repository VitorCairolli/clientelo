package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.Address;
import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExpectedOrderList {

    public List<Order> expectedOrders;

    @BeforeEach
    void setup(){
        expectedOrders = new ArrayList<>();

        expectedOrders.add(
                new Order("INFORMÁTICA",
                        "Notebook Samsung",
                        new Client("ANA",
                                "anaAgiota@gmail.com",
                                new Address("Rua Pinheiros Grandes",
                                        "552",
                                        "ap 52")),
                        BigDecimal.valueOf(3523.00).setScale(2),
                        1,
                        LocalDate.parse("01-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))

        );
        expectedOrders.add(
                new Order("MÓVEIS",
                        "Sofá 3 lugares",
                        new Client("ANA",
                                "anaAgiota@gmail.com",
                                new Address("Rua Pinheiros Grandes",
                                        "552",
                                        "ap 52")),
                        BigDecimal.valueOf(2500.00).setScale(2),
                        1,
                        LocalDate.parse("05-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("LIVROS",
                        "Clean Architecture",
                        new Client("ANA",
                                "anaAgiota@gmail.com",
                                new Address("Rua Pinheiros Grandes",
                                        "552",
                                        "ap 52")),
                        BigDecimal.valueOf(102.90).setScale(2),
                        2,
                        LocalDate.parse("08-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("MÓVEIS",
                        "Mesa de jantar 6 lugares",
                        new Client("ELI",
                                "ELIminadoraDeBobos@gmail.com",
                                new Address("Rua Macabra",
                                        "13",
                                        "ap 1")),
                        BigDecimal.valueOf(3678.98).setScale(2),
                        1,
                        LocalDate.parse("06-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("CELULARES",
                        "iPhone 13 Pro",
                        new Client("ANA",
                                "anaAgiota@gmail.com",
                                new Address("Rua Pinheiros Grandes",
                                        "552",
                                        "ap 52")),
                        BigDecimal.valueOf(9176.00).setScale(2),
                        6,
                        LocalDate.parse("13-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("INFORMÁTICA",
                        "Monitor Dell 27",
                        new Client("DANI",
                                "danista@gmail.com",
                                new Address("Rua DANIficada",
                                        "57",
                                        "nenhum")),
                        BigDecimal.valueOf(1889.00).setScale(2),
                        3,
                        LocalDate.parse("04-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("LIVROS",
                        "Implementing Domain-Driven Design",
                        new Client("GABI",
                                "gabinete@gmail.com",
                                new Address("Rua Casaco",
                                        "12",
                                        "nenhum")),
                        BigDecimal.valueOf(144.07).setScale(2),
                        3,
                        LocalDate.parse("10-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("AUTOMOTIVA",
                        "Jogo de pneus",
                        new Client("BIA",
                                "bianca@hotmail.com",
                                new Address("Rua Biancaneira",
                                        "781",
                                        "nenhum")),
                        BigDecimal.valueOf(1276.79).setScale(2),
                        1,
                        LocalDate.parse("15-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("LIVROS",
                        "Clean Code",
                        new Client("BIA",
                                "bianca@hotmail.com",
                                new Address("Rua Biancaneira",
                                        "781",
                                        "nenhum")),
                        BigDecimal.valueOf(95.17).setScale(2),
                        1,
                        LocalDate.parse("09-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("CELULARES",
                        "Galaxy S22 Ultra",
                        new Client("DANI",
                                "danista@gmail.com",
                                new Address("Rua DANIficada",
                                        "57",
                                        "nenhum")),
                        BigDecimal.valueOf(8549.1).setScale(2),
                        5,
                        LocalDate.parse("14-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("INFORMÁTICA",
                        "Macbook Pro 16",
                        new Client("CAIO",
                                "caioNoBait@gmail.com",
                                new Address("Rua Tetriz",
                                        "444",
                                        "Moro na casa do fundo")),
                        BigDecimal.valueOf(31752.00).setScale(2),
                        1,
                        LocalDate.parse("03-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("LIVROS",
                        "Refactoring Improving the Design of Existing Code",
                        new Client("DANI",
                                "danista@gmail.com",
                                new Address("Rua DANIficada",
                                        "57",
                                        "nenhum")),
                        BigDecimal.valueOf(173.90).setScale(2),
                        1,
                        LocalDate.parse("12-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("MÓVEIS",
                        "Cama queen size",
                        new Client("DANI",
                                "danista@gmail.com",
                                new Address("Rua DANIficada",
                                        "57",
                                        "nenhum")),
                        BigDecimal.valueOf(3100.00).setScale(2),
                        2,
                        LocalDate.parse("07-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("AUTOMOTIVA",
                        "Central multimidia",
                        new Client("CAIO",
                                "caioNoBait@gmail.com",
                                new Address("Rua Tetriz",
                                        "444",
                                        "Moro na casa do fundo")),
                        BigDecimal.valueOf(711.18).setScale(2),
                        1,
                        LocalDate.parse("16-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("LIVROS",
                        "Building Microservices",
                        new Client("CAIO",
                                "caioNoBait@gmail.com",
                                new Address("Rua Tetriz",
                                        "444",
                                        "Moro na casa do fundo")),
                        BigDecimal.valueOf(300.28).setScale(2),
                        2,
                        LocalDate.parse("11-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
        expectedOrders.add(
                new Order("INFORMÁTICA",
                        "Galaxy Tab S8",
                        new Client("BIA",
                                "bianca@hotmail.com",
                                new Address("Rua Biancaneira",
                                        "781",
                                        "nenhum")),
                        BigDecimal.valueOf(5939.1).setScale(2),
                        4,
                        LocalDate.parse("02-01-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")))
        );
    }
}
