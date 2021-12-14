package Bank;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(Client holder) {
        super(holder);
    }

    @Override
    public void withdraw(double value) {
        super.balance -= value * this.getWithdrawalFee();
    }

    public double getWithdrawalFee() {
        return 1.05;
    }
}
