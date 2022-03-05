package br.com.bytebank.Bank.Models;

public enum TypeCreditCard {
    Gold(3.000, 1.200, 300.0),
    Platinum(8.000, 5400, 450.00),
    Black(20.000, 100000.00,1.000);

    final double minimumIncome;
    final double limit;
    final double annuity;

    TypeCreditCard(double minimumIncome, double limit, double annuity) {
        this.minimumIncome = minimumIncome;
        this.limit = limit;
        this.annuity = annuity;
    }
}
