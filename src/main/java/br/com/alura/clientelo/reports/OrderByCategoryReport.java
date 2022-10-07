package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;

public class OrderByCategoryReport implements Report {

    private static final Logger logger = LoggerFactory.getLogger(OrderByCategoryReport.class);

    @Override
    public void logReport(List<Pedido> pedidos) {
        if (pedidos == null) {
            logger.info("!!!!!FOI PASSADO UMA LISTA Nula!!!!!\n");
            return;
        }

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
}
