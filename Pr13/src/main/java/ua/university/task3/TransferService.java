package ua.university.task3;

public class TransferService {

    public static void transfer(Account from, Account to, int amount) {

        Account firstLock;
        if (from.getId() < to.getId()) firstLock = from;
        else firstLock = to;

        Account secondLock;
        if (from.getId() < to.getId()) secondLock = to;
        else secondLock = from;

        synchronized (firstLock) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {}

            synchronized (secondLock) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
    }
}
