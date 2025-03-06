package models;

public class CreditCardPayment extends User implements Payment{
    private String cardNumber;
    private double creditLimit;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void payMent(double amount) {
        if(creditLimit < amount) {
            System.out.println("Não foi possivel realizar a transação: limite do cartão insuficiente.");
        }
        this.creditLimit -= amount;
    }
}
