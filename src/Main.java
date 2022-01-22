import br.com.bytebank.Bank.Models.Client;
import br.com.bytebank.Bank.Models.CurrentAccount;

public class Main {
    public static void main(String[] args) {

        Client client = new Client(
                "Raul Pacheco Domingos",
                "000.000.000-00",
                1234.56,
                "Quality Assurance Analyst"
        );

        CurrentAccount checkingAccount = new CurrentAccount(client);


    }
}
