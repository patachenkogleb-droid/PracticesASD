
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount("abc", 100);

        account.deposit(50);

        assertEquals(150, account.getBalance(), "Баланс мав збільшитися на суму депозиту!");
    }
}