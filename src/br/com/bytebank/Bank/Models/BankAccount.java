package br.com.bytebank.Bank.Models;

import br.com.bytebank.Bank.Exceptions.InsufficientBalanceException;
import br.com.bytebank.Bank.Exceptions.LowExpectedValueException;

public abstract class BankAccount {
    protected double balance;
    int agency;
    String number;
    Client holder;

    /**
     *
     * @param holder - Bank account holder
     */
    public BankAccount(Client holder) {
        this.holder = holder;
    }

    public double balance() {
        return this.balance;
    }

    /**
     *
     * @param value - Deposit value
     */
    public void deposit(double value) {
        this.balance += value;
    }

    /**
     * @param value - Withdrawal value
     * @param fee - Withdrawal fee
     * @throws InsufficientBalanceException - Withdrawal amount greater than the amount in the account
     * @throws LowExpectedValueException - Withdrawal amount lower than allowed
     */
    public void withdraw(double value, double fee) throws InsufficientBalanceException, LowExpectedValueException {
        double totalValue = value * fee;

        if (this.balance - totalValue < 0) {
            if (fee > 1) {
                throw new InsufficientBalanceException("Saldo insufiente! Seu saldo é de R$ " + this.balance + " e você tentou retirar R$" + totalValue + " sendo R$" + (totalValue - value) + " de taxa de transação.");
            } else {
                throw new InsufficientBalanceException("Saldo insufiente! Seu saldo é de R$ " + this.balance + " e você tentou retirar R$" + totalValue + ".");
            }
        }

        if (value < 5) {
            throw new LowExpectedValueException("Você tentou sacar R$" + value + " e o valor mínimo para saque é de R$5,00.");
        }

        this.balance -= value;

    }

    /**
     *
     * @param value - Transfer value
     * @param destiny - Destination bank account
     */
    public void transfer(double value, BankAccount destiny) {
        if (value <= this.balance) {
            destiny.deposit(value);
            this.balance -= value;
        }
    }
}
