public class Main {
    public static void main(String[] args) {
        Order validOrder = new Order(1, "test@gmail.com", 1000);
        System.out.println("Valid: " + validOrder);

        try {
            Order invalidOrder = new Order(0, "bademail.com", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}