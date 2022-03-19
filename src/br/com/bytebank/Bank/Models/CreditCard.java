package br.com.bytebank.Bank.Models;

public class CreditCard {
    private final Client client;
    private final TypeCreditCard typeCreditCard;
    private final Invoice invoice = new Invoice();

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
        return this.invoice.invoiceAmount();
    }

    public double getFreeBalance() {
        return this.typeCreditCard.getLimit() - this.getInvoice();
    }

    public boolean spendCredit(double value) {
        Purchase purchase = new Purchase(value);

        if (value > 0 && value <= this.getFreeBalance()) {
            this.invoice.addPurchase(purchase);
            return true;
        }
        return false;
    }

    public boolean payBill(double value) {
        return this.invoice.pay(value);
    }
}
