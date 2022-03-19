import br.com.bytebank.Bank.Models.Client;
import br.com.bytebank.Bank.Models.CurrentAccount;
import br.com.bytebank.Bank.Models.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CurrentAccountTest {

    CurrentAccount currentAccount;

    @Before
    public void setUp() {
        Person person = new Person("Matheus", "000.000.000-00");
        Client client = new Client(person, 1212.00, "Atendente");
        this.currentAccount = new CurrentAccount(client);
    }

    @Test
    public void ensureThereIsNoFeeDiscount() {
        Assert.assertTrue(this.currentAccount.getWithdrawalFee() > 1);
    }

    @Test
    public void withdrawHalfOfTheBalance() {
        double depositAmount = 500;
        double withdrawalValue = 250;
        double withdrawalAmountWithFee = withdrawalValue * this.currentAccount.getWithdrawalFee();
        double finalBalance = depositAmount - withdrawalAmountWithFee;

        this.currentAccount.deposit(depositAmount);
        this.currentAccount.withdraw(withdrawalValue);

        Assert.assertEquals(this.currentAccount.balance(), finalBalance, 0.0);
    }

    @Test
    public void withdrawTheEntireBalance() {
        double depositAmount = 500;
        double withdrawalValue = 476.19;
        double withdrawalAmountWithFee = withdrawalValue * this.currentAccount.getWithdrawalFee();
        double finalBalance = depositAmount - withdrawalAmountWithFee;

        this.currentAccount.deposit(depositAmount);
        this.currentAccount.withdraw(withdrawalValue);

        Assert.assertEquals(this.currentAccount.balance(), finalBalance, 0.0);
    }

    @Test
    public void withdrawOverBalance() {
        double depositAmount = 500;
        double withdrawalValue = 500.01;
        double finalBalance = 500;

        this.currentAccount.deposit(depositAmount);
        this.currentAccount.withdraw(withdrawalValue);

        Assert.assertEquals(finalBalance, this.currentAccount.balance(), 0.0);
    }

    @Test
    public void depositWithNegativeValue() {
        this.currentAccount.deposit(-1);

        Assert.assertEquals(0, this.currentAccount.balance(), 0.0);
    }

    @Test
    public void transferLessThanTheAccountBalance() {
        Person person1 = new Person("Maria", "000.000.000-00");
        Client client1 = new Client(person1, 3212.00, "Programadora");
        CurrentAccount mariaAccount = new CurrentAccount(client1);

        Person person2 = new Person("Matheus", "000.000.000-01");
        Client client2 = new Client(person2, 1212.00, "Atendente");
        CurrentAccount matheusAccount = new CurrentAccount(client2);

        mariaAccount.deposit(100);
        matheusAccount.deposit(100);
        mariaAccount.transfer(50, matheusAccount);

        Assert.assertEquals(50, mariaAccount.balance(), 0.0);
        Assert.assertEquals(150, matheusAccount.balance(), 0.0);
    }

    @Test
    public void transferTheEntireAccountBalance() {
        Person person1 = new Person("Maria", "000.000.000-00");
        Client client1 = new Client(person1, 3212.00, "Programadora");
        CurrentAccount mariaAccount = new CurrentAccount(client1);

        Person person2 = new Person("Matheus", "000.000.000-01");
        Client client2 = new Client(person2, 1212.00, "Atendente");
        CurrentAccount matheusAccount = new CurrentAccount(client2);

        mariaAccount.deposit(100);
        matheusAccount.deposit(100);
        mariaAccount.transfer(100, matheusAccount);

        Assert.assertEquals(0, mariaAccount.balance(), 0.0);
        Assert.assertEquals(200, matheusAccount.balance(), 0.0);
    }

    @Test
    public void transferMoreThanTheAccountBalance() {
        Person person1 = new Person("Maria", "000.000.000-00");
        Client client1 = new Client(person1, 3212.00, "Programadora");
        CurrentAccount mariaAccount = new CurrentAccount(client1);

        Person person2 = new Person("Matheus", "000.000.000-01");
        Client client2 = new Client(person2, 1212.00, "Atendente");
        CurrentAccount matheusAccount = new CurrentAccount(client2);

        mariaAccount.deposit(100);
        matheusAccount.deposit(100);
        mariaAccount.transfer(101, matheusAccount);

        Assert.assertEquals(100, mariaAccount.balance(), 0.0);
        Assert.assertEquals(100, matheusAccount.balance(), 0.0);
    }
}
