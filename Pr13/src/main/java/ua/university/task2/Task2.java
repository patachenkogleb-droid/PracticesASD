package ua.university.task2;

public class Task2 {

    public static void runReservationThreads(Inventory inventory) {
        Runnable task = () -> inventory.reserve(60);

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}
    }
}