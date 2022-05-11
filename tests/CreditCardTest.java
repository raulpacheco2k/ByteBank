import br.com.bytebank.Bank.Models.Client;
import br.com.bytebank.Bank.Models.CreditCard;
import br.com.bytebank.Bank.Models.Person;
import br.com.bytebank.Bank.Models.TypeCreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    CreditCard creditCard;

    @BeforeEach
    void setUp() {
        Person person = new Person("Matheus da Silva", "123.456.789-12");
        Client client = new Client(person, 1100.00, "Analyst Test");
        this.creditCard = new CreditCard(client, TypeCreditCard.Gold);
    }

    @Test
    void spendBelowTheLimit() {
        double creditCardLimite = TypeCreditCard.Gold.getLimit();
        double amountSpent = 900;
        double atualFreeBalance = creditCardLimite - amountSpent;

        this.creditCard.spendCredit(amountSpent);

        assertEquals(this.creditCard.getFreeBalance(), atualFreeBalance, 0.0);
        assertEquals(this.creditCard.getInvoice(), amountSpent, 0.0);
    }

    @Test
    void spendAllTheLimit() {
        double amountSpent = this.creditCard.getTypeCreditCard().getLimit();
        double expectedFreeBalance = TypeCreditCard.Gold.getLimit() - amountSpent;

        this.creditCard.spendCredit(amountSpent);

        double freeBalance = this.creditCard.getFreeBalance();
        double invoice = this.creditCard.getInvoice();

        assertEquals(freeBalance, expectedFreeBalance, 0.0);
        assertEquals(invoice, amountSpent, 0.0);
    }

    @Test
    void spendOverTheLimit() {
        double amountSpent = 1300;
        double expectedInvoice = 0;

        this.creditCard.spendCredit(amountSpent);

        assertEquals(this.creditCard.getFreeBalance(), this.creditCard.getTypeCreditCard().getLimit(), 0.0);
        assertEquals(this.creditCard.getInvoice(), expectedInvoice, 0.0);
    }

    @Test
    void payLessThanTheTotalPayable() {
        double amountSpent = 200;
        double amountPay = 100;
        double expectedInvoice = 100;

        this.creditCard.spendCredit(amountSpent);

        assertTrue(this.creditCard.payBill(amountPay));
        assertEquals(expectedInvoice, this.creditCard.getInvoice(), 0.0);
    }

    @Test
    void payTheTotalToPay() {
        this.creditCard.spendCredit(1200);

        assertTrue(this.creditCard.payBill(1200));
        assertEquals(0, this.creditCard.getInvoice(), 0.0);
    }

    @Test
    void payMoreThanTheTotalPayable() {
        this.creditCard.spendCredit(1000);

        assertFalse(this.creditCard.payBill(1001));
        assertEquals(1000, this.creditCard.getInvoice(), 0.0);
    }
}
