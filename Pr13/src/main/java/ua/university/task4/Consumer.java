package ua.university.task4;

import java.util.concurrent.ConcurrentHashMap;


public class Consumer implements Runnable {
    TicketQueue queue;
    ConcurrentHashMap<String, Integer> map;

    public Consumer(TicketQueue q, ConcurrentHashMap<String, Integer> map) {
        this.queue = q;
        this.map = map;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SupportTicket t = queue.getTicket();

                if (t.topic().equals("STOP")) {
                    break;
                }

                int count = map.getOrDefault(t.topic(), 0);
                map.put(t.topic(), count + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
