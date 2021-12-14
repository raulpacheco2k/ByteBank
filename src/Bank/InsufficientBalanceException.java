package Bank;

public class InsufficientBalanceException extends Exception {

    InsufficientBalanceException() {
        super();
    }

    InsufficientBalanceException(String string) {
        super(string);
    }

}
