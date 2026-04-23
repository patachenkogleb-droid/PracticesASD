interface PaymentMethod {
    String name();
    void pay(int amount);

    default void payWithFee(int amount, int fee) {
        pay(amount + fee);
    }
}

class CardPayment implements PaymentMethod {
    @Override
    public String name() {
        return "Card";
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Card");
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public String name() {
        return "PayPal";
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via PayPal");
    }
}

class PaymentProcessor {
    public void process(PaymentMethod method, int amount) {
        method.pay(amount);
    }
}

public class Task1 {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod card = new CardPayment();
        processor.process(card, 100);
        card.payWithFee(100, 10);

        PaymentMethod paypal = new PayPalPayment();
        processor.process(paypal, 100);
        paypal.payWithFee(100, 10);

    }
}