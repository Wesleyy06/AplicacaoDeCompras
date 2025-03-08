package models;

public class CashPayment extends User implements Payment{
    private double moneyInWalllet;
    private double paymentAmount;

    public CashPayment(String name, String cpf, double moneyInWalllet) {
        super(name, cpf);
        this.moneyInWalllet = moneyInWalllet;
    }

    public double getMoneyInWalllet() {
        return moneyInWalllet;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        if(paymentAmount > moneyInWalllet) {
            System.out.println("Você não possui dinheiro suficiente para realizar esta transação!");
        }
        else {
            this.paymentAmount = paymentAmount;
        }

    }

    @Override
    public void payMent(Product amount) {
        if(moneyInWalllet < amount.getValue()) {
            System.out.println("Saldo insuficiente na carteira para efeutar a compra.");
        }
        if (paymentAmount > amount.getValue()) {
            double change = this.paymentAmount -= amount.getValue();
            System.out.println("Você recebeu um troco no valor de: R$" + change);
        }
        this.moneyInWalllet -= amount.getValue();
        System.out.println("Saldo atualizado da carteira R$" + getMoneyInWalllet());
    }
}
