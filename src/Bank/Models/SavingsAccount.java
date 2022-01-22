package Bank.Models;

import Bank.Exceptions.InsufficientBalanceException;
import Bank.Exceptions.LowExpectedValueException;
import Bank.Taxation;

public class SavingsAccount extends BankAccount implements Taxation {
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
