import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}

class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public java.util.Optional<User> findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return java.util.Optional.of(user);
            }
        }
        return java.util.Optional.empty();
    }
}

public class Optional {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        repo.addUser(new User("Taras", "taras@gmail.com"));

        User user1 = repo.findByEmail("taras@gmail.com")
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("Result 1: " + user1);

        User user2 = repo.findByEmail("unknown@gmail.com")
                .orElseGet(() -> new User("Guest", "guest@temp.com"));
        System.out.println("Result 2: " + user2);

        try {
            repo.findByEmail("oleh@gmail.com")
                    .orElseThrow(() -> new IllegalArgumentException("Error: User missing!"));
        } catch (IllegalArgumentException e) {
            System.out.println("Result 3: Exception caught -> " + e.getMessage());
        }

        System.out.println(" Чому Optional не слід використовувати у полях та параметрах? \n " +
                "В полях: зайва пам'ять, не серіалізується (не зможемо записати об'єкт у файл" +
                "В параметрах: зайва обгортка, незручно викликати, не рятує від null" +
                "Використовувати: тільки як результат роботи методу (return value)");
    }
}