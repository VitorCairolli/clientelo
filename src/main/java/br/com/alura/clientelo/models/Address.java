package br.com.alura.clientelo.models;

public class Address {

    private String street;
    private String number;
    private String complement;

    public Address(String street, String number, String complement) {
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }
}
