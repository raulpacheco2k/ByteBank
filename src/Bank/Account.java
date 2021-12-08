package Bank;

public abstract class Account {
    private double balance;
    int agency;
    String number;
    Client holder;

    public Account(Client holder) {
        this.holder = holder;
    }

    public double balance() {
        return this.balance;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value;
    }

    public void transfer(double value, Account destiny) {
        if (value <= this.balance) {
            destiny.deposit(value);
            this.balance -= value;
        }
    }
}
