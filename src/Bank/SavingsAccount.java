package Bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(Client holder) {
        super(holder);
    }

    @Override
    public void withdraw(double value) {
        super.withdraw(value);
    }
}
