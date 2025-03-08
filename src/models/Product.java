package models;

public class Product {
    private String name;
    private double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "nome: " + name + "\nValor: R$" + value;
    }
}

