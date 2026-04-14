package ua.university.task4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketQueue {
    public static final SupportTicket POISON = new SupportTicket(0, "none", "STOP");

    BlockingQueue<SupportTicket> q = new LinkedBlockingQueue<>(5);

    public void addTicket(SupportTicket t) throws InterruptedException {
        q.put(t);
    }

    public SupportTicket getTicket() throws InterruptedException {
        return q.take();
    }
}