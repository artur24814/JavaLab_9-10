import exceptionsGen.NullPointerExceptionGenerator;
import account.*;

public class App {
    public static void main(String[] args) {
        try {
            NullPointerExceptionGenerator.raiseNullPointerException();
        } catch (NullPointerException e){
            System.out.println("Złapano NullPointerException");
            e.printStackTrace();
            System.out.println(e.toString());
        }

        Account senderAccount = new Account("Jan Kowalski", 500, "12345");
        Account receiverAccount = new Account("Anna Nowak", 1000, "67890");

        try {
            System.out.println("Próba przelewu 1000 zł z konta o saldzie: " + senderAccount.getBalance());
            senderAccount.transfer(receiverAccount, 1000);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Błąd: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
        } finally {
            System.out.println("Stan konta nadawcy: " + senderAccount.getBalance());
            System.out.println("Stan konta odbiorcy: " + receiverAccount.getBalance());
        }
    }
}
