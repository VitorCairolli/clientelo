package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TopThreeByQuantityReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(TopThreeByQuantityReport.class);

    @Override
    public void logReport(List<Pedido> pedidos) {
        if (pedidos == null) {
            logger.info("!!!!!FOI PASSADO UMA LISTA Nula!!!!!\n");
            return;
        }

        Pedido.orderByQuantity(pedidos);

        logger.info("##### RELATÓRIO 3 PEDIDOS COM MAIOR QUANTIDADE #####");
        for (int i = 1; i <= 3 && i <= pedidos.size(); i++) {
            logger.info("PRODUTO: {}", pedidos.get(pedidos.size() - i).getProduto());
            logger.info("QUANTIDADE {}\n", pedidos.get(pedidos.size() - i).getQuantidade());
        }
    }
}
