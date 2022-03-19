package br.com.bytebank.Bank.Models;

public class Purchase {

    private final double value;

    public Purchase(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
