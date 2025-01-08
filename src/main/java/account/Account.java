package account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import account.AmountBelowZeroException;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public int transfer (Account targetAccount, int amount) throws AmountBelowZeroException {
        if (amount < 0 ){
            throw new AmountBelowZeroException("The amount must be greater than zero.");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
        return this.getBalance();
    }

    public int withdraw(int amount) {
        this.balance -= amount;
        return this.getBalance();
    }

    public int deposit(int amount) {
        this.balance += amount;
        return this.getBalance();
    }
}
