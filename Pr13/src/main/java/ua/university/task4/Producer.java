package ua.university.task4;

public class Producer implements Runnable {
    TicketQueue queue;

    public Producer(TicketQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 15; i++) {
                String topic = (i % 2 == 0) ? "Technical" : "Billing";
                queue.addTicket(new SupportTicket(i, "User" + i, topic));
            }

            queue.addTicket(TicketQueue.POISON);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
