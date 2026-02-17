// ! GOD OBJECT
// робить все
// складно тестувати
public class AntiPatterns {
    static class GodObject {
        void doEverything() {
        }
    }

    // ! SPAGHETTI CODE
    // багато умов
    // негнучко
    static void spaghetti(boolean flag, boolean otherFlag) {
        if (flag) {
            if (otherFlag) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        } else {
            System.out.println("C");
        }
    }

    // ! LONG METHOD
    // робить багато
    // складно змінювати
    static void longMethod() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        for (int i = 0; i < 100; i++) {
            sum += i * i;
        }
        System.out.println(sum);
    }

    // ! PRIMITIVE OBSESSION
    // використовує String для складних написів
    // треба через Object
    static class User {
        String email;
        String phone;
    }
}
