package br.com.bytebank.Bank.Models;

public class CreditCard {
    private final Client client;
    private final TypeCreditCard typeCreditCard;
    private double invoice;

    public CreditCard(Client client, TypeCreditCard typeCreditCard) {
        this.client = client;
        this.typeCreditCard = typeCreditCard;
    }

    public Client getClient() {
        return client;
    }

    public TypeCreditCard getTypeCreditCard() {
        return typeCreditCard;
    }

    public double getInvoice() {
        return invoice;
    }

    public double getFreeBalance() {
        return this.typeCreditCard.limit - this.getInvoice();
    }

    public boolean spendCredit(double value) {
        if (value > 0 && value <= this.getFreeBalance()) {
            this.invoice += value;
            return true;
        }
        return false;
    }

    public boolean payBill(double value) {
        if (value > 0) {
            this.invoice -= value;
            return true;
        }
        return false;
    }
}
