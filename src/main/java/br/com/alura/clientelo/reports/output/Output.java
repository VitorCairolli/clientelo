package br.com.alura.clientelo.reports.output;

public interface Output {

    @Override
    public String toString();

    abstract class Builder{
        public abstract Output build();

        public abstract Output newInstance();
    }
}
