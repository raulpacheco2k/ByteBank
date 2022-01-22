package br.com.bytebank.Bank.Exceptions;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String string) {
        super(string);
    }

}
