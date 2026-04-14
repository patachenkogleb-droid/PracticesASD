package ua.university;


import ua.university.task1.Order;
import ua.university.task1.TaskRunner;
import ua.university.task2.Inventory;
import ua.university.task2.SynchronizedInventory;
import ua.university.task2.UnsafeInventory;
import ua.university.task3.Account;
import ua.university.task3.TransferService;

import java.util.List;

import static ua.university.task2.Task2.runReservationThreads;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // task 1
        try {
            List<Order> orders = List.of(
                    new Order(1, 15000),
                    new Order(2, 5000),
                    new Order(3, 20000),
                    new Order(4, 1000)
            );

            Runnable maxTask = () -> {
                int max = 0;
                for (Order o : orders) {
                    if (o.totalCents() > max) max = o.totalCents();
                }
                System.out.println("Найбільша сума: " + max);
            };

            Runnable sumTask = () -> {
                long total = 0;
                for (Order o : orders) {
                    total += o.totalCents();
                }
                System.out.println("Загальна сума: " + total);
            };

            System.out.println("Завдання 1");
            TaskRunner.runAndWait(List.of(maxTask, sumTask));
            System.out.println("Усі потоки завершили роботу.\n");

        } catch (InterruptedException e) {
            System.err.println("Роботу потоків було перервано!");
        }


        // task 2
        System.out.println("Завдання 2: Одна ітерація");
        Inventory unsafe = new UnsafeInventory(100);
        runReservationThreads(unsafe);
        System.out.println("Залишок (Unsafe): " + unsafe.available());

        Inventory safe = new SynchronizedInventory(100);
        runReservationThreads(safe);
        System.out.println("Залишок (Safe): " + safe.available());

        System.out.println("\nЗавдання 2: 500 ітерацій");
        int errors = 0;

        for (int i = 0; i < 500; i++) {
            Inventory testInv = new UnsafeInventory(100);
            runReservationThreads(testInv);
            if (testInv.available() < 0) {
                errors++;
            }
        }

        System.out.println("Інваріант available >= 0 порушено разів: " + errors + " з 500");


        // task3
        System.out.println("\nЗавдання 3");
        Account acc1 = new Account(1, 1000);
        Account acc2 = new Account(2, 1000);

        Runnable transferToAcc2 = () -> {
            for (int i = 0; i < 500; i++) {
                TransferService.transfer(acc1, acc2, 1);
            }
        };

        Runnable transferToAcc1 = () -> {
            for (int i = 0; i < 500; i++) {
                TransferService.transfer(acc2, acc1, 1);
            }
        };

        Thread tA = new Thread(transferToAcc2);
        Thread tB = new Thread(transferToAcc1);

        tA.start();
        tB.start();

        tA.join();
        tB.join();

        System.out.println("Баланс Account 1: " + acc1.getBalance());
        System.out.println("Баланс Account 2: " + acc2.getBalance());
        System.out.println("Сумарний баланс (очікуємо 2000): " + (acc1.getBalance() + acc2.getBalance()));
        System.out.println("Дедлоку не сталося, потоки успішно завершені!\n");
    }
}