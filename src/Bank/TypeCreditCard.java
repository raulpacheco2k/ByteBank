package Bank;

public enum TypeCreditCard {
    Gold(3.000, 300.0),
    Platinum(8.000, 450.00),
    Black(20.000, 1.000);

    final double minimumIncome;
    final double annuity;

    TypeCreditCard(double minimumIncome, double annuity) {
        this.minimumIncome = minimumIncome;
        this.annuity = annuity;
    }
}
