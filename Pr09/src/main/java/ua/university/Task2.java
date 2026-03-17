package ua.university;

public class Task2 {

    public String buildTicketId(String base) {
        class IdBuilder {
            String build() {
                return base + "-" + System.currentTimeMillis();
            }
        }
        return new IdBuilder().build();
    }

    public Runnable runOnce() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Running once");
            }
        };
    }
}