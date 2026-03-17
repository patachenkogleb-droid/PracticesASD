package ua.university;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1:");
        Car audi = new Car("Audi");
        audi.Engine_spec();

        Library antonovychs = new Library("Antonovych`s Library");
        Library.Book kobzar = antonovychs.new Book("Kobzar", "T. H. Shevchenko");
        kobzar.bookLabel();

        System.out.println("\nTask 2:");
        Task2 task2 = new Task2();

        String ticketId = task2.buildTicketId("NAUKMA");
        System.out.println("Generated ID: " + ticketId);

        Runnable runnable = task2.runOnce();
        runnable.run();

        System.out.println("\nTask 3:");
        Ticket t1 = new Ticket();
        t1.setPriority(2);
        t1.setCreatedAt(2026);

        Ticket t2 = new Ticket();
        t2.setPriority(1);
        t2.setCreatedAt(2025);

        Ticket t3 = new Ticket();
        t3.setPriority(2);
        t3.setCreatedAt(2024);

        List<Ticket> tickets = new ArrayList<>(Arrays.asList(t1, t2, t3));

        System.out.println("Before sorting:");
        tickets.forEach(System.out::println);

        Task3.TicketComparators.sortTickets(tickets, "priorityThenCreatedAt");

        System.out.println("\nAfter sorting (priorityThenCreatedAt):");
        tickets.forEach(System.out::println);

        Task3 task3 = new Task3();
        task3.sortAnon(tickets);
        task3.sortLambda(tickets);
        task3.sortMR(tickets);

        System.out.println("\nSorting methods executed successfully.");

        System.out.println("\nTask 4:");

        UserDTO userdto = new UserDTO();
        System.out.println(userdto.toString());

        Price price = new Price(1000);
        System.out.println(price.toString());

        CheckoutRequest checkoutRequest = CheckoutRequest.builder()
                .orderId(5)
                .total(50000)
                .userEmail("taras@gmail.com")
                .build();
        System.out.println(checkoutRequest.toString());
    }
}