package models;

public class CashPayment extends User implements Payment{
    private double moneyInWalllet;

    public CashPayment(String name, String cpf) {
        super(name, cpf);
    }

    public double getMoneyInWalllet() {
        return moneyInWalllet;
    }

    @Override
    public void payMent(double amount) {
        if(moneyInWalllet < amount) {
            System.out.println("Saldo insuficiente na carteira para efeutar a compra.");
        }
        this.moneyInWalllet -= amount;
    }
}
