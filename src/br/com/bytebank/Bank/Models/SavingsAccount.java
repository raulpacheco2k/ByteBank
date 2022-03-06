package br.com.bytebank.Bank.Models;

import br.com.bytebank.Bank.Exceptions.InsufficientBalanceException;
import br.com.bytebank.Bank.Exceptions.LowExpectedValueException;
import br.com.bytebank.Bank.Interfaces.Taxation;

public class SavingsAccount extends BankAccount implements Taxation {
    public SavingsAccount(Client holder) {
        super(holder);
    }

    @Override
    public double balance() {
        return super.balance();
    }

    public void withdraw(double value) {
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
