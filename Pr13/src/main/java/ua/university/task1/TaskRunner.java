package ua.university.task1;

import java.util.ArrayList;
import java.util.List;


public class TaskRunner {

    public static void runAndWait(List<Runnable> tasks) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (Runnable task : tasks) {
            Thread t = new Thread(task);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}

