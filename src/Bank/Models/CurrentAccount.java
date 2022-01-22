package Bank.Models;

import Bank.Exceptions.InsufficientBalanceException;
import Bank.Exceptions.LowExpectedValueException;
import Bank.Taxation;

public class CurrentAccount extends BankAccount implements Taxation {

    public CurrentAccount(Client holder) {
        super(holder);
    }

    public void withdraw(double value){
        try {
            super.withdraw(value, this.getWithdrawalFee());
        } catch (InsufficientBalanceException | LowExpectedValueException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public double getWithdrawalFee() {
        return 1;
    }
}
