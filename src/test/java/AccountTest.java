import account.Account;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testValidTransfer() {
        Account sourceAccount = new Account("Jan Kowalski", 1000, "12345");
        Account targetAccount = new Account("Anna Nowak", 500, "67890");

        int result = sourceAccount.transfer(targetAccount, 200);
        assertEquals(800, sourceAccount.getBalance(), "The source account balance should be reduced by 200");
        assertEquals(700, targetAccount.getBalance(), "The source account balance should be increased by 200");

        assertEquals(800, result);
    }
}
