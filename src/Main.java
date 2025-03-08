import models.CashPayment;
import models.CreditCardPayment;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Olá bem vindo como você se chama? ");
        String name = scanner.nextLine();
        System.out.print("Por favor insira seu segundo nome: ");
        String secondName = scanner.nextLine();
        System.out.print("E por fim o seu cpf: ");
        String cpf = scanner.nextLine();


        String option = "Digite [1] para continuar ou [0] para sair;" ;
        int optionSelected;
        boolean exit = true;

        List<Product> buyList = new ArrayList<>();

        var creditCard = new CreditCardPayment(name, cpf);
        boolean registrationCompleted = false;

        while (exit) {
            System.out.print("Por favor insira o nome do produto desejado: ");
            String productName = scanner.nextLine();
            System.out.print("Agora o seu valor: R$");
            double productValue = scanner.nextDouble();

            var product = new Product(productName, productValue);

            System.out.println("Agora escolha a forma de pagamento.");
            System.out.println("Digite [1] para credito ou [2] para dinheiro");
            int paymentMethod = scanner.nextInt();
            scanner.nextLine();

            switch (paymentMethod) {
                case 1:
                    if(!registrationCompleted) {
                        System.out.print("Digite o numero do cartão: ");
                        String cardNumber = scanner.nextLine();
                        creditCard.setCardNumber(cardNumber);

                        System.out.println("Insira o seu limite de credito: R$");
                        double creditLimit = scanner.nextDouble();
                        creditCard.setCreditLimit(creditLimit);

                        registrationCompleted = true;
                    }

                    System.out.println(creditCard.getCreditLimit());
                    creditCard.payMent(product);
                    buyList.clear();
                    buyList.addAll(creditCard.getBuyList());

                    System.out.println(option);
                    optionSelected = scanner.nextInt();
                    if (optionSelected == 0) {
                        exit = false;
                    }
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Valor disponivel na carteira: R$");
                    double moneyInWallet = scanner.nextDouble();

                    var cashPayment = new CashPayment(name, cpf, moneyInWallet);

                    System.out.print("Valor de pagamento: R$");
                    double cashValue = scanner.nextDouble();
                    cashPayment.setPaymentAmount(cashValue);
                    cashPayment.payMent(product);

                    System.out.println(option);
                    optionSelected = scanner.nextInt();
                    if (optionSelected == 0) {
                        exit = false;
                    }
                    break;
                default:
                    System.out.println("Opcao escolhida invalida.");
                    break;
            }
        }
        scanner.close();

        System.out.println("Lista de compras");
        for (Product c : buyList) {
            System.out.println(c);
        }
    }
}