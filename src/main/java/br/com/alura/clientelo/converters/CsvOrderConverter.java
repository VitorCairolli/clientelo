package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvOrderConverter {

    public static List<Order> convert(String fileName) {
        try {
            URL recursoCSV = ClassLoader.getSystemResource(fileName);

            if(recursoCSV == null) throw new FileNotFoundException("File " + fileName + " nor found.");

            Path caminhoDoArquivo = Path.of(recursoCSV.toURI());

            Scanner leitorDeLinhas = new Scanner(caminhoDoArquivo);

            leitorDeLinhas.nextLine();

            List<Order> pedidos = new ArrayList<>();
            int i = 0;

            while (leitorDeLinhas.hasNextLine()) {
                String linha = leitorDeLinhas.nextLine();
                String[] registro = linha.split(",");

                Category categoria = new Category(registro[0]);
                BigDecimal preco = new BigDecimal(registro[2]);
                int quantidade = Integer.parseInt(registro[3]);
                LocalDate data = LocalDate.parse(registro[4], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                String clientName = registro[5];
                String clientEmail = registro[6];
                String clientAddressStreet = registro[7];
                String clientAddressNumber = registro[8];
                String clientAddressComplement = registro[9];
                Product produto = new Product(registro[1], preco, "", quantidade, categoria);

                Client client = new Client(clientName,
                        clientEmail,
                        new Address(clientAddressStreet,
                                clientAddressNumber,
                                clientAddressComplement));

                List<ProductItem> productItems = new ArrayList<>();
                ProductItem productItem = new ProductItem(produto, null, quantidade, null);
                productItems.add(productItem);
                Order pedido = new Order(productItems, client, data);
                productItem.setOrder(pedido);
                pedidos.add(pedido);

                i++;
            }

            return pedidos;
        } catch (URISyntaxException e) {
            throw new RuntimeException(String.format("Arquivo {} não localizado!", fileName));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao abrir Scanner para processar arquivo!");
        }
    }
}
