package br.com.alura.clientelo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    private Long id;
    private String name;
    private String email;
    @Embedded
    private Address address;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    Client(){}

    public Client(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) &&
                email.equals(client.email) &&
                address.equals(client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, address);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
