package models;

public class CashPayment extends User implements Payment{
    private double moneyInWalllet;

    @Override
    public void payMent(double amount) {
        if(moneyInWalllet < amount) {
            System.out.println("Saldo insuficiente na carteira para efeutar a compra.");
        }
        this.moneyInWalllet -= amount;
    }
}
