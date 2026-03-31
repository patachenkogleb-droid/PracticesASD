import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class Event {
    private String title;
    private LocalDateTime start;
    private long durationMinutes;
    private ZoneId zone;
    private String track;

    public Event(String title, LocalDateTime start, long durationMinutes, ZoneId zone, String track) {
        this.title = title;
        this.start = start;
        this.durationMinutes = durationMinutes;
        this.zone = zone;
        this.track = track;
    }

    public LocalDateTime end() {
        return start.plusMinutes(durationMinutes);
    }

    public String label() {
        return "Event " + title + ", track " + track;
    }
}
