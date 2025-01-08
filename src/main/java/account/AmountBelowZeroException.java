package account;

public class AmountBelowZeroException extends Exception {
    public AmountBelowZeroException () {}

    public AmountBelowZeroException (String message){
        super(message);
    }
}
