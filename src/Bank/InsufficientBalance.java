package Bank;

public class InsufficientBalance extends RuntimeException {

    InsufficientBalance() {
        super();
    }

    InsufficientBalance(String string) {
        super(string);
    }

}
