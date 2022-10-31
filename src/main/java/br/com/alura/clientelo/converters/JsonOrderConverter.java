package br.com.alura.clientelo.converters;

import br.com.alura.clientelo.models.Order;
import br.com.alura.clientelo.reports.ReportGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JsonOrderConverter {

    private static final Logger logger = LoggerFactory.getLogger(JsonOrderConverter.class);

    public static List<Order> convert(String fileName) {
            ObjectMapper mapper = JsonMapper.builder()
                    .findAndAddModules()
                    .build();
            URL jsonResource = ClassLoader.getSystemResource(fileName);
            List<Order> orders = new ArrayList<>();

            try {
                orders = Arrays.asList(mapper.readValue(jsonResource, Order[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }

            return orders;
    }
}
