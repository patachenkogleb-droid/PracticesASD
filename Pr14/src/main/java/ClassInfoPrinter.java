import java.util.Arrays;

public class ClassInfoPrinter {
   public void print(Class<?> clazz) {
       System.out.println("Name: " + clazz.getName());
       System.out.println("Superclass: " + clazz.getSuperclass());
       System.out.println("Interfaces: " + Arrays.toString(clazz.getInterfaces()));
       System.out.println("Declared Fields: " + Arrays.toString(clazz.getDeclaredFields()));
       System.out.println("Declared Methods: " + Arrays.toString(clazz.getDeclaredMethods()));
   }
}
