package ua.university;

import java.util.List;

public class ResultLab {

    public sealed interface Result permits Success, Failure {}

    public record Success(int data) implements Result {}

    public record Failure(String message) implements Result {}

    private List<Result> results = List.of(
            new Success(100),
            new Failure("Timeout error"),
            new Success(200),
            new Failure("Invalid syntax"),
            new Success(300)
    );

    public int getSuccessCount() {
        return (int) results.stream()
                .filter(r -> r instanceof Success)
                .count();
    }

    public int getFailureCount() {
        return (int) results.stream()
                .filter(r -> r instanceof Failure)
                .count();
    }

    public List<String> getErrorMessages() {
        return results.stream()
                .filter(Failure.class::isInstance)
                .map(Failure.class::cast)
                .map(Failure::message)
                .toList();
    }
}