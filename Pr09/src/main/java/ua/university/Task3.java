package ua.university;

import java.util.Comparator;
import java.util.List;

public class Task3 {

    public void sortAnon(List<Ticket> tickets) {
        tickets.sort(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket t1, Ticket t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });
    }

    public void sortLambda(List<Ticket> tickets) {
        tickets.sort((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()));
    }

    public void sortMR(List<Ticket> tickets) {
        tickets.sort(Comparator.comparingInt(Ticket::getPriority));
    }

    public static class TicketComparators {

        public static final Comparator<Ticket> BY_PRIORITY = Comparator.comparingInt(Ticket::getPriority);

        public static final Comparator<Ticket> BY_CREATED_AT = Comparator.comparing(Ticket::getCreatedAt);

        public static final Comparator<Ticket> BY_PRIORITY_THEN_CREATED_AT = BY_PRIORITY.thenComparing(BY_CREATED_AT);

        public static void sortTickets(List<Ticket> tickets, String strategy) {
            switch (strategy) {
                case "priority":
                    tickets.sort(BY_PRIORITY);
                    break;
                case "createdAt":
                    tickets.sort(BY_CREATED_AT);
                    break;
                case "priorityThenCreatedAt":
                    tickets.sort(BY_PRIORITY_THEN_CREATED_AT);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown strategy");
            }
        }
    }
}