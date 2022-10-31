package br.com.alura.clientelo.models;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderTest {

    Order subject;

    Order moreExpansiveOrder;

    Order lessExpansiveOrder;

    @BeforeEach
    void setup(){

        subject = new Order("Livros",
                "O Hobbit",
                new Client("Cairolli", "vsc@email.com",
                        new Address("Rua do chá", "47", "Do lado da maior pedra")),
                new BigDecimal(32.50).setScale(2),
                3,
                LocalDate.parse("07/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        moreExpansiveOrder = new Order("Livros",
                "A Sociedade do Anel",
                new Client("Cairolli", "vsc@email.com",
                        new Address("Rua do chá", "47", "Do lado da maior pedra")),
                new BigDecimal(33.50).setScale(2),
                3,
                LocalDate.parse("07/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        lessExpansiveOrder = new Order("Livros",
                "As Duas Torres",
                new Client("Cairolli", "vsc@email.com",
                        new Address("Rua do chá", "47", "Do lado da maior pedra")),
                new BigDecimal(31.50).setScale(2),
                3,
                LocalDate.parse("07/01/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    }

    @Test
    void getSubjectTotalPrice(){
        Assert.assertEquals(subject.getTotalPrice(), BigDecimal.valueOf(97.50).setScale(2));
    }

    @Test
    void isMoreExpansiveThanShouldReturnTrueIfSubjectIsMoreExpansive(){
        Assert.assertTrue(subject.isMoreExpensiveThan(lessExpansiveOrder));
    }

    @Test
    void isMoreExpansiveThanShouldReturnFalseIfSubjectIsLessExpansive(){
        Assert.assertFalse(subject.isMoreExpensiveThan(moreExpansiveOrder));
    }

    @Test
    void isMoreExpansiveThanShouldReturnFalseIfSubjectIsEquallyExpansive(){
        Assert.assertFalse(subject.isMoreExpensiveThan(subject));
    }

    @Test
    void isLessExpansiveThanShouldReturnTrueIfSubjectIsMoreExpansive(){
        Assert.assertTrue(subject.isLessExpensiveThan(moreExpansiveOrder));
    }

    @Test
    void isLessExpansiveThanShouldReturnFalseIfSubjectIsLessExpansive(){
        Assert.assertFalse(subject.isLessExpensiveThan(lessExpansiveOrder));
    }

    @Test
    void isLessExpansiveThanShouldReturnFalseIfSubjectIsEquallyExpansive(){
        Assert.assertFalse(subject.isLessExpensiveThan(subject));
    }
}