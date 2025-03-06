package models;

public class CreditCardPayment extends User implements Payment{
    private String cardNumber;
    private double creditLimit;

    public CreditCardPayment(String name, String cpf, String cardNumber) {
        super(name, cpf);
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void payMent(double amount) {
        if(creditLimit < amount) {
            System.out.println("Não foi possivel realizar a transação: limite do cartão insuficiente.");
        }
        this.creditLimit -= amount;
    }
}
