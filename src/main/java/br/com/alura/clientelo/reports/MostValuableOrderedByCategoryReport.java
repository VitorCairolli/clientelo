package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MostValuableOrderedByCategoryReport implements Report{

    private static final Logger logger = LoggerFactory.getLogger(MostValuableOrderedByCategoryReport.class);

    @Override
    public void logReport(List<Pedido> pedidos) {
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
}
