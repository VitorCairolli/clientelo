package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.daos.ClientDao;
import br.com.alura.clientelo.reports.output.OrderReportOutput;
import br.com.alura.clientelo.reports.output.Output;
import br.com.alura.clientelo.vo.ClientTotalPriceAndOrdersVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LoyalClientsReport implements Report{
    @Override
    public void logReport() {
        ClientDao clientDao = new ClientDao();
        List<ClientTotalPriceAndOrdersVO> loyalClients = clientDao.findLoyalClient();

        List<Output> report = new ArrayList<>();

        loyalClients.subList(0,3).forEach(client -> {
            report.add(OrderReportOutput.Builder.newInstance()
                    .setClient(client.getName())
                    .setTotalPrice(client.getTotalPrice())
                    .setQuantity(new BigDecimal(client.getTotalOrders()))
                    .build());
        });

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title() {
        return "LOYAL CLIENT REPORT";
    }
}
