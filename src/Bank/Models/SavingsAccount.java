package Bank;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(Client holder) {
        super(holder);
    }

    public void withdraw(double value) {
        try {
            super.withdraw(value, this.getWithdrawalFee());
        } catch (InsufficientBalanceException | LowExpectedValueException exception) {
            exception.getMessage();
        }
    }

    public double getWithdrawalFee() {
        return 1;
    }
}
