package br.com.bytebank.Bank.Models;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private final List<Purchase> purchases = new ArrayList<>();
    private double amountPaid;

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }

    public double invoiceAmount() {
        double invoiceAmount = 0;

        for (Purchase purchase : this.purchases) {
            invoiceAmount += purchase.getValue();
        }

        return invoiceAmount - amountPaid;
    }

    public Purchase getPurchase(int index) {
        return this.purchases.get(index);
    }

    public boolean pay(double value) {
        if (value > 0 && value <= this.invoiceAmount()) {
            amountPaid += value;
            return true;
        }
        return false;
    }
}
