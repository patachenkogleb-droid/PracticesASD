import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ZoneId kyivZone = ZoneId.of("Europe/Kiev");

        Event event1 = new Event("A", LocalDateTime.of(2026, 3, 24, 10, 0), 90, kyivZone, "Exam");
        Event event2 = new Event("B", LocalDateTime.of(2026, 3, 24, 11, 0), 60, kyivZone, "Study");
        Event event3 = new Event("C", LocalDateTime.of(2026, 3, 24, 14, 0), 80, kyivZone, "Lecture");
        Event event4 = new Event("D", LocalDateTime.of(2026, 3, 24, 19, 0), 180, kyivZone, "Practice");

        System.out.println(event1.label());
        System.out.println(event2.label());
        System.out.println(event3.label());
        System.out.println(event4.label());

        List<Event> events = Arrays.asList(event1, event2, event3, event4);

        System.out.println("\nTask 2");
        System.out.println("\nFilter");
        Predicate<Event> isMorning = e -> e.getStart().getHour() < 12;
        Predicate<Event> isExam = e -> "Exam".equals(e.getTrack());
        Predicate<Event> morningStudyOrExam = isMorning.and(isExam.or(e -> "Study".equals(e.getTrack())));

        System.out.println("Morning Study or Exam Events:");
        EventLab.pick(events, morningStudyOrExam).forEach(e -> System.out.println(e.label()));

        System.out.println("\nConflicts:");
        EventLab.findConflicts(events).forEach(System.out::println);

        System.out.println("\nEvent Labels:");
        EventLab.labels(events, Event::label).forEach(System.out::println);

        System.out.println("\nTask 3");
        LambdaRefactorLab.sortLambda(events);
        EventLab.notifyAll(events, e -> System.out.println("Sorted: " + e.getTitle() + " at " + e.getStart()));

        System.out.println("\nTask 4");
        System.out.println("Minutes between A and C: " + DateTimeLab.minutesBetween(event1, event3));
        System.out.println("D in Tokyo time: " + DateTimeLab.startInZone(event4, "Asia/Tokyo"));
    }
}