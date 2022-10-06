package br.com.alura.clientelo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
        Pedido[] pedidosArray = ProcessadorDeCsv.processaArquivo("pedidos.csv");
        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < pedidosArray.length; i++) {
            if (pedidosArray[i] != null) pedidos.add(pedidosArray[i]);
        }
        
        topThreeByQuantityReport(pedidos);
        orderByCategoryReport(pedidos);
        orderByMostValuableOrderByCategoryReport(pedidos);
        relatorioGeral(pedidos);
    }

    private static void topThreeByQuantityReport(List<Pedido> pedidos) {
        Pedido.orderByQuantity(pedidos);

        logger.info("##### RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE #####");
        for (int i = 1; i <= 3 && i <= pedidos.size(); i++) {
            logger.info("PRODUTO: {}", pedidos.get(pedidos.size() - i).getProduto());
            logger.info("QUANTIDADE {}\n", pedidos.get(pedidos.size() - i).getQuantidade());
        }
    }

    private static void orderByCategoryReport(List<Pedido> pedidos) {
        Pedido.orderByCategory(pedidos);
        int quantity = pedidos.get(0).getQuantidade();
        BigDecimal montante = pedidos.get(0).getPreco();

        logger.info("##### RELATÓRIO DE PEDIDOS ORDENADOS POR CATEGORIA ALFABETICA #####");
        for (int i = 1; i < pedidos.size(); i++) {
            if (!(pedidos.get(i - 1).getCategoria().equals(pedidos.get(i).getCategoria())) || i == pedidos.size() - 1) {
                logger.info("CATEGORIA: {}", pedidos.get(i - 1).getCategoria());
                logger.info("QUANTIDADE {}", quantity);
                logger.info("MONTANTE {}\n", montante);

                quantity = pedidos.get(i).getQuantidade();
                montante = pedidos.get(i).getPreco().multiply(BigDecimal.valueOf(quantity));

            } else {
                quantity += pedidos.get(i).getQuantidade();
                montante = montante.add(pedidos.get(i).getPreco().multiply(BigDecimal.valueOf(pedidos.get(i).getQuantidade())));
            }
        }
    }

    private static void orderByMostValuableOrderByCategoryReport (List < Pedido > pedidos) {
        if (pedidos == null) {
            logger.info("!!!!!FOI PASSADO UMA LISTA Nula!!!!!\n");
            return;
        }

        Pedido.orderByCategory(pedidos);

        Pedido mostValuable = pedidos.get(0);

        logger.info("##### RELATÓRIO DE PEDIDOS MAIS VALIOSOS POR CATEGORIA EM ORDEM ALFABETICA #####");
        for (int i = 1; i < pedidos.size(); i++) {
            if (!(mostValuable.getCategoria().equals(pedidos.get(i).getCategoria())) || i == pedidos.size() - 1) {
                logger.info("CATEGORIA: {}", mostValuable.getCategoria());
                logger.info("PRODUTO {}", mostValuable.getProduto());
                logger.info("PRECO {}\n", mostValuable.getPreco());
                mostValuable = pedidos.get(i);
            } else {
                if (mostValuable.getPreco().compareTo(pedidos.get(i).getPreco()) < 0)
                    mostValuable = pedidos.get(i);
            }
        }
    }

    private static void relatorioGeral (List < Pedido > pedidos) {

        int totalDeProdutosVendidos = 0;
        int totalDePedidosRealizados = 0;
        BigDecimal montanteDeVendas = BigDecimal.ZERO;
        Pedido pedidoMaisBarato = null;
        Pedido pedidoMaisCaro = null;

        String[] categoriasProcessadas = new String[10];
        int totalDeCategorias = 0;

        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedidoAtual = pedidos.get(i);

            if (pedidoAtual == null) {
                break;
            }

            if (pedidoMaisBarato == null || pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())).compareTo(pedidoMaisBarato.getPreco().multiply(new BigDecimal(pedidoMaisBarato.getQuantidade()))) < 0) {
                pedidoMaisBarato = pedidoAtual;
            }

            if (pedidoMaisCaro == null || pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())).compareTo(pedidoMaisCaro.getPreco().multiply(new BigDecimal(pedidoMaisCaro.getQuantidade()))) > 0) {
                pedidoMaisCaro = pedidoAtual;
            }

            montanteDeVendas = montanteDeVendas.add(pedidoAtual.getPreco().multiply(new BigDecimal(pedidoAtual.getQuantidade())));
            totalDeProdutosVendidos += pedidoAtual.getQuantidade();
            totalDePedidosRealizados++;

            boolean jahProcessouCategoria = false;
            for (int j = 0; j < categoriasProcessadas.length; j++) {
                if (pedidoAtual.getCategoria().equalsIgnoreCase(categoriasProcessadas[j])) {
                    jahProcessouCategoria = true;
                }
            }

            if (!jahProcessouCategoria) {
                totalDeCategorias++;

                if (categoriasProcessadas[categoriasProcessadas.length - 1] != null) {
                    categoriasProcessadas = Arrays.copyOf(categoriasProcessadas, categoriasProcessadas.length * 2);
                } else {
                    for (int k = 0; k < categoriasProcessadas.length; k++) {
                        if (categoriasProcessadas[k] == null) {
                            categoriasProcessadas[k] = pedidoAtual.getCategoria();
                            break;
                        }
                    }
                }
            }
        }

        logger.info("##### RELATÓRIO DE VALORES TOTAIS #####");
        logger.info("TOTAL DE PEDIDOS REALIZADOS: {}", totalDePedidosRealizados);
        logger.info("TOTAL DE PRODUTOS VENDIDOS: {}", totalDeProdutosVendidos);
        logger.info("TOTAL DE CATEGORIAS: {}", totalDeCategorias);
        logger.info("MONTANTE DE VENDAS: {}", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(montanteDeVendas.setScale(2, RoundingMode.HALF_DOWN)));
        logger.info("PEDIDO MAIS BARATO: {} ({})", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisBarato.getPreco().multiply(new BigDecimal(pedidoMaisBarato.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)), pedidoMaisBarato.getProduto());
        logger.info("PEDIDO MAIS CARO: {} ({})\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisCaro.getPreco().multiply(new BigDecimal(pedidoMaisCaro.getQuantidade())).setScale(2, RoundingMode.HALF_DOWN)), pedidoMaisCaro.getProduto());
        logger.info("### FIM DO RELATÓRIO ###");
    }
}

