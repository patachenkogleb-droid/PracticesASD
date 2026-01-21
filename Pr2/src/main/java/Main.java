class BankAccount {
    private final String accountNumber;
    private double balance;

    BankAccount (String accountNumber, double balance) {
        if (balance < 0){
            throw new IllegalArgumentException("Баланс не може бути від'ємним!");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if (amount < 0){
            System.out.println("Введіть невід'ємне значення!");
        }
        else {
            balance += amount;
            System.out.println("Баланс змінено.");
        }
    }

    public void withdraw(double amount){
        if (amount < 0){
            System.out.println("Введіть невід'ємне значення!");
        }
        else if (amount > balance) {
            System.out.println("Сума не може перевищувати поточний баланс!");
        } else {
            balance -= amount;
            System.out.println("Баланс змінено.");
        }
    }
}



public class Main{
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("abc", 40);
        System.out.println("Поточний баланс: " + bankAccount.getBalance());

        bankAccount.deposit(-60);
        bankAccount.withdraw(50);
    }
}