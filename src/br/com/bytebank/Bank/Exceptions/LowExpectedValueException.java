package br.com.bytebank.Bank.Exceptions;

public class LowExpectedValueException extends Exception {

    public LowExpectedValueException() {
        super();
    }

    public LowExpectedValueException(String string) {
        super(string);
    }

}
