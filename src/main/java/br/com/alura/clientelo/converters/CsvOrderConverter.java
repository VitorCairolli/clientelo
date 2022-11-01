package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.Address;
import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Order;

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
            Path caminhoDoArquivo = Path.of(recursoCSV.toURI());

            Scanner leitorDeLinhas = new Scanner(caminhoDoArquivo);

            leitorDeLinhas.nextLine();

            List<Order> pedidos = new ArrayList<>();
            int i = 0;

            while (leitorDeLinhas.hasNextLine()) {
                String linha = leitorDeLinhas.nextLine();
                String[] registro = linha.split(",");

                String categoria = registro[0];
                String produto = registro[1];
                BigDecimal preco = new BigDecimal(registro[2]);
                int quantidade = Integer.parseInt(registro[3]);
                LocalDate data = LocalDate.parse(registro[4], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                String clientName = registro[5];
                String clientEmail = registro[6];
                String clientAddressStreet = registro[7];
                String clientAddressNumber = registro[8];
                String clientAddressComplement = registro[9];

                Client client = new Client(clientName,
                        clientEmail,
                        new Address(clientAddressStreet,
                                clientAddressNumber,
                                clientAddressComplement));

                Order pedido = new Order(categoria, produto, client, preco, quantidade, data);
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
