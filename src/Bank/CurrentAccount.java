package Bank;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(Client holder) {
        super(holder);
    }

    @Override
    public void withdraw(double value){
        double totalValue = value * this.getWithdrawalFee();
        super.withdraw(totalValue);
    }

    private double getWithdrawalFee() {
        return 1.05;
    }
}
