import account.*;

import exceptionsGen.NullPointerExceptionGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testValidTransfer() throws AmountBelowZeroException, NotEnoughMoneyException {
        Account sourceAccount = new Account("Jan Kowalski", 1000, "12345");
        Account targetAccount = new Account("Anna Nowak", 500, "67890");

        int result = sourceAccount.transfer(targetAccount, 200);
        assertEquals(800, sourceAccount.getBalance(), "The source account balance should be reduced by 200");
        assertEquals(700, targetAccount.getBalance(), "The source account balance should be increased by 200");

        assertEquals(800, result);
    }

    @Test
    public void testTransferWithNegativeAmount() throws AmountBelowZeroException {
        Account sourceAccount = new Account("Jan Kowalski", 1000, "12345");
        Account targetAccount = new Account("Anna Nowak", 500, "67890");

        assertThrows(AmountBelowZeroException.class, () -> sourceAccount.transfer(targetAccount, -200));
    }

    @Test
    public void testWithdrawWhenBalanceIsTooSmall() throws NotEnoughMoneyException{
        Account account = new Account("Jan Kowalski", 100, "12345");

        assertThrows(NotEnoughMoneyException.class, () -> account.withdraw(200));
    }
}
