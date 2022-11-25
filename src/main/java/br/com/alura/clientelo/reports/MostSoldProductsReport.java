package br.com.alura.clientelo.reports;

import br.com.alura.clientelo.daos.ProductDao;
import br.com.alura.clientelo.reports.output.Output;
import br.com.alura.clientelo.reports.output.ProductReportOutput;
import br.com.alura.clientelo.vo.MostSoldProductsVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MostSoldProductsReport implements Report{
    @Override
    public void logReport() {
        ProductDao productDao = new ProductDao();
        List<MostSoldProductsVO> mostSoldProducts =productDao.findMostSoldProducts();

        List<Output> report = new ArrayList<>();

        mostSoldProducts = mostSoldProducts.stream().filter(mostSoldProductVO -> mostSoldProductVO.getTimesSold().compareTo(3L) >= 0).toList();

        mostSoldProducts.forEach(productVO -> {
            report.add(ProductReportOutput.Builder.newInstance()
                    .setProductId(productVO.getId())
                    .setName(productVO.getName())
                    .setQuantityInStock(BigDecimal.valueOf(productVO.getQuantityInStock()))
                    .setPrice(productVO.getPrice())
                    .setTimesSold(productVO.getTimesSold())
                    .setDescription(productVO.getDescription())
                    .build());
        });

        ReportGenerator.logReport(title(), report);
    }

    @Override
    public String title() {
        return "RELATÓRIO DE DE PRODUTOS MAIS VENDIDOS";
    }
}
