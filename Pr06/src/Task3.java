public class Task3 {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new OrderItem("MacBook", Money.ofDollars(2000), 1));

        PaymentDetails details = new PaymentDetails("card123");
        Email email = new Email("user@example.com");

        // TIGHT COUPLING (погано)
        System.out.println("Tight Coupling");

        TightCheckoutProcessor tight = new TightCheckoutProcessor();
        tight.checkout(order, details, email);


        // LOOSE COUPLING + DIP (добре)
        System.out.println("\n=== Loose Coupling (DIP) ===");

        // реальний сценарій
        PaymentGateway realGateway = new StripePaymentGateway();
        NotificationService notifier = new EmailNotificationService();

        LooseCheckoutProcessor looseProd = new LooseCheckoutProcessor(realGateway, notifier);
        looseProd.checkout(order, details, email);

        // тестовий сценарій (Fake Gateway)
        // легко підміняємо платіжку на фейкову без зміни коду процесора
        System.out.println("\n[Testing Failure Scenario]");
        FakePaymentGateway fakeGateway = new FakePaymentGateway();
        fakeGateway.setFail(true); // Налаштовуємо фейк на помилку

        LooseCheckoutProcessor looseTest = new LooseCheckoutProcessor(fakeGateway, notifier);
        PaymentResult result = looseTest.checkout(order, details, email);

        System.out.println("Result: " + result); // Очікуємо: FAIL: Card declined
    }
}