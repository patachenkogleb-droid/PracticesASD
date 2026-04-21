package task2;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Оплата карткою на суму: " + amount + " грн");
    }
}
