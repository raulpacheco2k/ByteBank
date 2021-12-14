package Bank;

public abstract class BankAccount {
    protected double balance;
    int agency;
    String number;
    Client holder;

    public BankAccount(Client holder) {
        this.holder = holder;
    }

    public double balance() {
        return this.balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) throws InsufficientBalance {
        if (this.balance - value < 0) {
            throw new InsufficientBalance("Saldo insufiente! Seu saldo é de apenas R$" + this.balance + " e você tentou retirar R$" + value);
        }

        this.balance -= value;

    }

    public void transfer(double value, BankAccount destiny) {
        if (value <= this.balance) {
            destiny.deposit(value);
            this.balance -= value;
        }
    }
}
