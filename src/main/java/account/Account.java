package account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public int transfer (Account targetAccount, int amount) {
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
