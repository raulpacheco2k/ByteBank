package Bank;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(Client holder) {
        super(holder);
    }

    @Override
    public void withdraw(double value){
        double totalValue = value * this.getWithdrawalFee();
        try {
            super.withdraw(totalValue);
        } catch (InsufficientBalanceException | LowExpectedValueException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private double getWithdrawalFee() {
        return 1.05;
    }
}
