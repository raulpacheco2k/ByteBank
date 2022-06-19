package br.com.bytebank.Bank.Models;

import br.com.bytebank.Bank.Exceptions.InsufficientBalanceException;
import br.com.bytebank.Bank.Exceptions.LowExpectedValueException;
import br.com.bytebank.Bank.Interfaces.Taxation;

import java.util.Comparator;

public class CurrentAccount extends BankAccount implements Taxation, Comparator<CurrentAccount> {

    public CurrentAccount(Client holder) {
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
        return 1.05;
    }

    @Override
    public int compare(CurrentAccount currentAccount1, CurrentAccount currentAccount2) {

        String fullName1 = currentAccount1.getHolder().getFullName();
        String fullName2 = currentAccount2.getHolder().getFullName();

        return fullName1.compareTo(fullName2);
    }
}
