import models.CreditCardPayment;
import models.Product;

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

        boolean exit = true;

        while (exit) {
            System.out.print("Por favor insira o nome do produto desejado: ");
            String productName = scanner.nextLine();
            System.out.print("Agora o seu valor: R$");
            double productValue = scanner.nextDouble();

            var product = new Product(productName, productValue);

            System.out.println("Agora escolha a forma de pagamento.");
            System.out.println("Digite 1 para credito ou 2 para dinheiro");
            int paymentMethod = scanner.nextInt();
            switch (paymentMethod) {
                case 1:
                    System.out.print("Digite o numero do cartão: ");
                    String cardNumber = scanner.nextLine();
                    var creditCard = new CreditCardPayment(name, cpf, cardNumber);
                    creditCard.payMent(product);
                    break;
                case 2:

            }
        }

    }
}