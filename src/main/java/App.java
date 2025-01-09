import exceptionsGen.NullPointerExceptionGenerator;
import account.*;
import fileHandler.*;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
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

        String INPUT_FILE = "InputFile.txt";
        String OUTPUT_FILE = "OutputFile.txt";

        FileFactory.createFileIfNotExists(INPUT_FILE, "Vistula vistula vistula Vistula.");
        FileFactory.createFileIfNotExists(OUTPUT_FILE);

        FileCopyReplaceSpaces fileHandler = new FileCopyReplaceSpaces(INPUT_FILE, OUTPUT_FILE);

        boolean result = fileHandler.replaceSpaces(" ", "-");
    }
}
