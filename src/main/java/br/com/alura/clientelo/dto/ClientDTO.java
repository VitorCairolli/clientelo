package br.com.alura.clientelo.dto;

import br.com.alura.clientelo.models.Address;
import br.com.alura.clientelo.models.Category;
import br.com.alura.clientelo.models.Client;
import br.com.alura.clientelo.models.Product;

public record ClientDTO(Long id, String name, String email, Address address) {

    public Client toEntity() {
        return new Client(name,
                email,
                address);
    }

    public static ClientDTO from(Client client){
        return new ClientDTO(client.getId(),
                client.getName(),
                client.getEmail(),
                client.getAddress());
    }
}
