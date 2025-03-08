package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CreditCardPayment extends User implements Payment{
    private String cardNumber;
    private double creditLimit;

    private List<Product> buyList;

    public CreditCardPayment(String name, String cpf) {
        super(name, cpf);
        this.buyList = new ArrayList<>();
    }

    public List<Product> getBuyList() {
        return buyList;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void payMent(Product amount) {
        if(creditLimit < amount.getValue()) {
            System.out.println("Não foi possivel realizar a transação: limite do cartão insuficiente.");
        } else {
            this.creditLimit -= amount.getValue();
            System.out.println("****************");
            System.out.println("Compra realizada com sucesso!");
            System.out.println("****************");
            System.out.println(("Limite de credito atualizado: R$" + getCreditLimit()));
            buyList.sort(Comparator.comparing(Product::getValue));
            buyList.add(amount);
        }
    }
}
