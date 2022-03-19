import br.com.bytebank.Bank.Models.Client;
import br.com.bytebank.Bank.Models.CreditCard;
import br.com.bytebank.Bank.Models.Person;
import br.com.bytebank.Bank.Models.TypeCreditCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreditCardTest {

    CreditCard creditCard;

    @Before
    public void setUp() {
        Person person = new Person("Matheus da Silva", "123.456.789-12");
        Client client = new Client(person, 1100.00, "Analyst Test");
        this.creditCard = new CreditCard(client, TypeCreditCard.Gold);
    }

    @Test
    public void spendBelowTheLimit() {
        double creditCardLimite = TypeCreditCard.Gold.getLimit();
        double amountSpent = 900;
        double atualFreeBalance = creditCardLimite - amountSpent;

        this.creditCard.spendCredit(amountSpent);

        Assert.assertEquals(this.creditCard.getFreeBalance(), atualFreeBalance, 0.0);
        Assert.assertEquals(this.creditCard.getInvoice(), amountSpent, 0.0);
    }

    @Test
    public void spendAllTheLimit() {
        double amountSpent = this.creditCard.getTypeCreditCard().getLimit();
        double atualFreeBalance = TypeCreditCard.Gold.getLimit() - amountSpent;


        this.creditCard.spendCredit(amountSpent);

        Assert.assertEquals(this.creditCard.getFreeBalance(), atualFreeBalance, 0.0);
        Assert.assertEquals(this.creditCard.getInvoice(), amountSpent, 0.0);
    }

    @Test
    public void spendOverTheLimit() {
        double amountSpent = 1300;
        double expectedInvoice = 0;

        this.creditCard.spendCredit(amountSpent);

        Assert.assertEquals(this.creditCard.getFreeBalance(), this.creditCard.getTypeCreditCard().getLimit(), 0.0);
        Assert.assertEquals(this.creditCard.getInvoice(), expectedInvoice, 0.0);
    }

    @Test
    public void payLessThanTheTotalPayable() {
        this.creditCard.spendCredit(200);

        Assert.assertTrue(this.creditCard.payBill(100));
        Assert.assertEquals(100, this.creditCard.getInvoice(), 0.0);
    }

    @Test
    public void payTheTotalToPay() {
        this.creditCard.spendCredit(1200);

        Assert.assertTrue(this.creditCard.payBill(1200));
        Assert.assertEquals(0, this.creditCard.getInvoice(), 0.0);
    }

    @Test
    public void payMoreThanTheTotalPayable() {
        this.creditCard.spendCredit(1000);

        Assert.assertFalse(this.creditCard.payBill(1001));
        Assert.assertEquals(1000, this.creditCard.getInvoice(), 0.0);
    }
}
