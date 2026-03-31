package ua.university;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookStream {
    public record Book(String title, String author, int year, List<String> tags) {}

    List<Book> books = List.of(
            new Book("Clean Code", "Robert Martin", 2008, List.of("clean", "practice", "java")),
            new Book("Effective Java", "Joshua Bloch", 2018, List.of("java", "best", "api")),
            new Book("Modern Java", "Nicolai Parlog", 2020, List.of("java", "streams", "records")),
            new Book("Java Concurrency", "Brian Goetz", 2006, List.of("concurrency", "java"))
    );

    public List<String> stream1 (){
        return books.stream()
                .filter(b -> b.year() > 2015)
                .map(b -> b.title().toUpperCase())
                .sorted()
                .limit(3)
                .toList();
    }

    public List<String> stream2() {
        return books.stream()
                .flatMap(b -> b.tags().stream())
                .distinct()
                .sorted()
                .toList();
    }

    public Map<String, Long> tagFrequency() {
        return books.stream()
                .flatMap(b -> b.tags().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    public List<String> topNTags(int n) {
        return tagFrequency().entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    // task 5
    public Map<Boolean, List<Book>> partitionBooks() {
        return books.stream()
                .collect(Collectors.partitioningBy(b -> b.year() > 2015));
    }
}
