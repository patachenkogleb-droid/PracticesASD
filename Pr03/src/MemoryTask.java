public class MemoryTask {

    // Внутрішній клас для демонстрації роботи з об'єктами в Heap
    static class Person {
        String name;

        Person(String name) {
            this.name = name;
        }
    }

    public void run() {

        int number = 100;
        int[] numbersArray = {10, 20, 30};
        Person person1 = new Person("Тарас");
        Person person2 = person1;

        System.out.println("1. Примітив (int): " + number);
        System.out.println("   Спостереження: Змінна зберігає саме значення '100'.\n");

        System.out.println("2. Масив (int[]): Довжина " + numbersArray.length);
        System.out.println("   Спостереження: Масив живе в Heap, ми маємо лише адресу.\n");

        System.out.println("3. Створено об'єкт person2 = person1");
        System.out.println("   Чи рівні посилання? " + (person1 == person2));

        person2.name = "Андрій";
        System.out.println("Перевіряємо person1.name: " + person1.name);

        System.out.println("\n Висновок");
        System.out.println("Примітиви копіюють значення");
        System.out.println("Об'єкти копіюють посилання");
    }

    public static void main(String[] args) {
        new MemoryTask().run();
    }
}