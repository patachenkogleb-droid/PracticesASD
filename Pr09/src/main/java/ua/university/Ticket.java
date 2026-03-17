package ua.university;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Ticket {
    private int priority;
    private int createdAt;
}
