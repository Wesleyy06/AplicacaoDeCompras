package models;

import java.util.ArrayList;
import java.util.List;

public class CreditCardPayment extends User implements Payment{
    private String cardNumber;
    private double creditLimit;
    private List<Product> buyList;

    public CreditCardPayment(String name, String cpf, String cardNumber) {
        super(name, cpf);
        this.cardNumber = cardNumber;
        this.buyList = new ArrayList<>();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void payMent(Product amount) {
        if(creditLimit < amount.getValue()) {
            System.out.println("Não foi possivel realizar a transação: limite do cartão insuficiente.");
        }
        this.creditLimit -= amount.getValue();
    }
}
