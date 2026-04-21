import task2.PaymentService;
import task2.ServiceFactory;
import task3.SetupFlow;
import task3.StepRunner;

public class Main {
    public static void main(String[] args) {
        Book kobzar = new Book("Kobzar", "T. H. SHevchenko", 350);

        System.out.println("Task 1");
        ClassInfoPrinter infoPrinter = new ClassInfoPrinter();
        infoPrinter.print(Book.class);


        System.out.println("\n Task 2");

        String cardClassName = "task2.CardPaymentService";
        String cashClassName = "task2.CashPaymentService";

        PaymentService cardService = ServiceFactory.create(cardClassName);
        PaymentService cashService = ServiceFactory.create(cashClassName);

        cardService.pay(1500.50);
        cashService.pay(400.0);


        System.out.println("\n Task 3");

        SetupFlow flow = new SetupFlow();
        StepRunner.run(flow);
    }
}