import br.com.bytebank.Bank.Models.Client;
import br.com.bytebank.Bank.Models.CurrentAccount;
import br.com.bytebank.Bank.Models.Person;
import org.junit.Assert;
import org.junit.Test;

public class CurrentAccountTest {

    @Test
    public void ensureThereIsNoFeeDiscount() {

        Person person = new Person("Matheus", "000.000.000-00");
        Client client = new Client(person, 1212.00, "Atendente");
        CurrentAccount currentAccount = new CurrentAccount(client);

        Assert.assertTrue(currentAccount.getWithdrawalFee() > 1);
    }
}
