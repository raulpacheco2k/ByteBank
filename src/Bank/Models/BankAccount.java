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

    public void withdraw(double value, double fee) throws InsufficientBalanceException, LowExpectedValueException {
        double totalValue = value * fee;

        if (this.balance - totalValue < 0) {
            throw new InsufficientBalanceException("Saldo insufiente! Seu saldo é de R$ " + this.balance + " e você tentou retirar R$" + totalValue + " sendo R$ " + (totalValue - value) + " de taxa.");
        }

        if (value < 5) {
            throw new LowExpectedValueException("Você tentou sacar R$" + value + " e o valor mínimo para saque é de R$5,00.");
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
