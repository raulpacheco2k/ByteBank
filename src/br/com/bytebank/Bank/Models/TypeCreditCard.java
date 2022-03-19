package br.com.bytebank.Bank.Models;

public enum TypeCreditCard {
    Gold(3000, 1200, 300),
    Platinum(8000, 5400, 450),
    Black(20000, 100000, 1000);

    final private double minimumIncome;
    final private double limit;
    final private double annuity;

    TypeCreditCard(double minimumIncome, double limit, double annuity) {
        this.minimumIncome = minimumIncome;
        this.limit = limit;
        this.annuity = annuity;
    }

    public double getMinimumIncome() {
        return minimumIncome;
    }

    public double getLimit() {
        return limit;
    }

    public double getAnnuity() {
        return annuity;
    }
}
