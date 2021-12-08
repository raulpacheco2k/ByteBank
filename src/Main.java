import Bank.CheckingAccount;
import Bank.Client;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(
                "Raul Pacheco Domingos",
                "Quality Assurance Analyst",
                "000.000.000-00"
        );

        CheckingAccount checkingAccount = new CheckingAccount(client);


    }
}
