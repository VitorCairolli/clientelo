package br.com.alura.clientelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pedido {

    private String categoria;
    private String produto;
    private String cliente;

    private BigDecimal preco;
    private int quantidade;

    private LocalDate data;

    public Pedido(String categoria, String produto, String cliente, BigDecimal preco, int quantidade, LocalDate data) {
        this.categoria = categoria;
        this.produto = produto;
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "categoria='" + categoria + '\'' +
                ", produto='" + produto + '\'' +
                ", cliente='" + cliente + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", data=" + data +
                '}';
    }

    public static void orderByQuantity(List<Pedido> list) {
        Comparator<Pedido> comparator = new Comparator<Pedido>() {
            @Override
            public int compare(Pedido o1, Pedido o2) {
                return o1.getQuantidade() - o2.getQuantidade();
            }
        };
        Collections.sort(list, comparator);
    }

    public static void orderByCategory(List<Pedido> list) {
        Comparator<Pedido> comparator = new Comparator<Pedido>() {
            @Override
            public int compare(Pedido o1, Pedido o2) {
                if(o2.getCategoria().length() < o1.getCategoria().length()){
                    Pedido temp = o1;
                    o1 = o2;
                    o2 = temp;
                }
                for (int i = 0; i < o1.getCategoria().length(); i++)
                    if(o1.getCategoria().charAt(i) != o2.getCategoria().charAt(i))
                        return o1.getCategoria().charAt(i) - o2.getCategoria().charAt(i);

                return 0;
            }
        };
        Collections.sort(list, comparator);
    }

}
