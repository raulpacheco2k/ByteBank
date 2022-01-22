package br.com.bytebank.Bank.Models;

import br.com.bytebank.Bank.Exceptions.InsufficientBalanceException;
import br.com.bytebank.Bank.Exceptions.LowExpectedValueException;
import br.com.bytebank.Bank.Interfaces.Taxation;

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
