package task2;

public class ServiceFactory {


    @SuppressWarnings("unchecked")
    public static <T> T create(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return (T) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}