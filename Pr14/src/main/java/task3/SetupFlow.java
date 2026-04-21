package task3;

public class SetupFlow {

    @Step(order = 2)
    private void second() {
        System.out.println("Другий метод (приватний)");
    }

    @Step(order = 1)
    public void first() {
        System.out.println("Перший метод");
    }

    @Step(order = 3)
    void third() {
        System.out.println("Третий метод");
    }

    public void doNothing() {
        System.out.println("ПОМИЛКА: метод без анотації");
    }

    /* Валідація сигнатури
    @Step(order = 4)
    public String invalidMethod() {
        return "Неправильна сигнатура";
    }
    */


    @Step(order = 5)
    private void methodThatFails() {
        throw new RuntimeException("Помилка");
    }
}