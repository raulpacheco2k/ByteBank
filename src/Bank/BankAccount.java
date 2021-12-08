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

    public abstract void withdraw(double value);

    public void transfer(double value, BankAccount destiny) {
        if (value <= this.balance) {
            destiny.deposit(value);
            this.balance -= value;
        }
    }
}
