import account.Account;
import exceptionsGen.NullPointerExceptionGenerator;

public class App {
    public static void main(String[] args) {
        try {
            NullPointerExceptionGenerator.raiseNullPointerException();
        } catch (NullPointerException e){
            System.out.println("Złapano NullPointerException");
            e.printStackTrace();
            System.out.println(e.toString());
        }

        Account sourceAccount = new Account("Jan Kowalski", 1000, "12345");
        Account targetAccount = new Account("Anna Nowak", 500, "67890");

        int result = sourceAccount.transfer(targetAccount, 200);

        System.out.println(result);
    }
}
