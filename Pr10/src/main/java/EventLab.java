import org.w3c.dom.events.EventException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EventLab {

    public static List<Event> pick(List<Event> list, Predicate<Event> predicate){
        List<Event> result = new ArrayList<>();
        for (Event event : list){
            if (predicate.test(event)) result.add(event);
        }
        return result;
    }

    public static List<String> labels(List<Event> events, Function<Event, String> function) {
        List<String> result = new ArrayList<>();
        for (Event e : events) {
            result.add(function.apply(e));
        }
        return result;
    }

    public static void notifyAll(List<Event> list, Consumer<Event> consumer){
        for (Event event : list){
            consumer.accept(event);
        }
    }

    public static Event create(Supplier<Event> supplier) {
        return supplier.get();
    }

    public static List<String> findConflicts(List<Event> events) {
        List<String> conflicts = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            for (int j = i + 1; j < events.size(); j++) {
                Event e1 = events.get(i);
                Event e2 = events.get(j);

                Instant start1 = e1.getStart().atZone(e1.getZone()).toInstant();
                Instant end1 = e1.end().atZone(e1.getZone()).toInstant();

                Instant start2 = e2.getStart().atZone(e2.getZone()).toInstant();
                Instant end2 = e2.end().atZone(e2.getZone()).toInstant();

                if (start1.isBefore(end2) && start2.isBefore(end1)) {
                    conflicts.add(e1.getTitle() + " <-> " + e2.getTitle());
                }
            }
        }
        return conflicts;
    }

}
