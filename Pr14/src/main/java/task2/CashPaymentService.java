package task2;

public class CashPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата готівкою на суму: " + amount + " грн");
    }
}
