import br.com.bytebank.Bank.Models.*;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Raul Pacheco Domingos", "000.000.000-00");

        Client client = new Client(
                person,
                1234.56,
                "Quality Assurance Analyst"
        );

        CurrentAccount checkingAccount = new CurrentAccount(client);
        CreditCard creditCard = new CreditCard(client, TypeCreditCard.Platinum);

        System.out.println(creditCard.getFreeBalance());
        creditCard.spendCredit(5000);
        System.out.println(creditCard.getFreeBalance());
        creditCard.spendCredit(350);
        System.out.println(creditCard.getFreeBalance());
        creditCard.payBill(500);
        System.out.println(creditCard.getFreeBalance());

    }
}
