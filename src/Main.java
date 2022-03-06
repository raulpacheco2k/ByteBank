import br.com.bytebank.Bank.Models.*;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Raul Pacheco Domingos", "000.000.000-00");

        Client client = new Client(
                person,
                1234.56,
                "Quality Assurance Analyst"
        );

        CurrentAccount currentAccount = new CurrentAccount(client);
        currentAccount.deposit(1000);
        currentAccount.withdraw(1200);

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
