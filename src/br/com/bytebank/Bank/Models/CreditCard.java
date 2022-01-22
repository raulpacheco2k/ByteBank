package br.com.bytebank.Bank.Models;

public class CreditCard {
    private Client client;
    private TypeCreditCard typeCreditCard;

    public CreditCard(Client client, TypeCreditCard typeCreditCard) {
        this.client = client;
        this.typeCreditCard = typeCreditCard;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TypeCreditCard getTypeCreditCard() {
        return typeCreditCard;
    }

    public void setTypeCreditCard(TypeCreditCard typeCreditCard) {
        this.typeCreditCard = typeCreditCard;
    }
}
