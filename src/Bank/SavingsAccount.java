package Bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(Client holder) {
        super(holder);
    }

    @Override
    public void withdraw(double value) {
        try {
            super.withdraw(value);
        } catch (InsufficientBalanceException | LowExpectedValueException exception) {
            exception.getMessage();
        }
    }
}
