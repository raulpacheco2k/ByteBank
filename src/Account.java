public class Account {
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

    public void receive(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value;
    }

    public void transfer(double value, Account destiny) {
        if (value <= this.balance) {
            destiny.receive(value);
            this.balance -= value;
        }
    }
}
