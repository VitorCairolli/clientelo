package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DefaultReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(DefaultReport.class);

    @Override
    public void logReport(List<Order> pedidos) {
        int totalDeProdutosVendidos = 0;
        int totalDePedidosRealizados = 0;
        BigDecimal montanteDeVendas = BigDecimal.ZERO;
        Order pedidoMaisBarato = null;
        Order pedidoMaisCaro = null;

        String[] categoriasProcessadas = new String[10];
        int totalDeCategorias = 0;

        for (int i = 0; i < pedidos.size(); i++) {
            Order pedidoAtual = pedidos.get(i);

            if (pedidoAtual == null) {
                break;
            }

            if (pedidoMaisBarato == null || pedidoAtual.getPrice().multiply(new BigDecimal(pedidoAtual.getQuantity())).compareTo(pedidoMaisBarato.getPrice().multiply(new BigDecimal(pedidoMaisBarato.getQuantity()))) < 0) {
                pedidoMaisBarato = pedidoAtual;
            }

            if (pedidoMaisCaro == null || pedidoAtual.getPrice().multiply(new BigDecimal(pedidoAtual.getQuantity())).compareTo(pedidoMaisCaro.getPrice().multiply(new BigDecimal(pedidoMaisCaro.getQuantity()))) > 0) {
                pedidoMaisCaro = pedidoAtual;
            }

            montanteDeVendas = montanteDeVendas.add(pedidoAtual.getPrice().multiply(new BigDecimal(pedidoAtual.getQuantity())));
            totalDeProdutosVendidos += pedidoAtual.getQuantity();
            totalDePedidosRealizados++;

            boolean jahProcessouCategoria = false;
            for (int j = 0; j < categoriasProcessadas.length; j++) {
                if (pedidoAtual.getCategory().equalsIgnoreCase(categoriasProcessadas[j])) {
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
                            categoriasProcessadas[k] = pedidoAtual.getCategory();
                            break;
                        }
                    }
                }
            }
        }

        logger.info("TOTAL DE PEDIDOS REALIZADOS: {}", totalDePedidosRealizados);
        logger.info("TOTAL DE PRODUTOS VENDIDOS: {}", totalDeProdutosVendidos);
        logger.info("TOTAL DE CATEGORIAS: {}", totalDeCategorias);
        logger.info("MONTANTE DE VENDAS: {}", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(montanteDeVendas.setScale(2, RoundingMode.HALF_DOWN)));
        logger.info("PEDIDO MAIS BARATO: {} ({})", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisBarato.getPrice().multiply(new BigDecimal(pedidoMaisBarato.getQuantity())).setScale(2, RoundingMode.HALF_DOWN)), pedidoMaisBarato.getProduct());
        logger.info("PEDIDO MAIS CARO: {} ({})\n", NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(pedidoMaisCaro.getPrice().multiply(new BigDecimal(pedidoMaisCaro.getQuantity())).setScale(2, RoundingMode.HALF_DOWN)), pedidoMaisCaro.getProduct());
        logger.info("### FIM DO RELATÓRIO ###");
    }

    @Override
    public String title(){
        return "RELATÓRIO DE VALORES TOTAIS";
    }
}
