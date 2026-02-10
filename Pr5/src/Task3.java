interface SmsNotifier {
    default void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

interface EmailNotifier {
    default void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class MultiNotifier implements SmsNotifier, EmailNotifier {
    @Override
    public void send(String message) {
        SmsNotifier.super.send(message);
        EmailNotifier.super.send(message);
    }
}

public class Task3 {
    public static void main(String[] args) {
        new MultiNotifier().send("Critical Alert!");
    }
}