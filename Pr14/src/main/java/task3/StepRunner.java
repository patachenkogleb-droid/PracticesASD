package task3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StepRunner {

    public static void run(Object target) {
        Class<?> clazz = target.getClass();

        Method[] allMethods = clazz.getDeclaredMethods();
        List<Method> stepMethods = new ArrayList<>();

        for (Method method : allMethods) {
            if (method.isAnnotationPresent(Step.class)) {

                if (method.getReturnType() != void.class) {
                    throw new StepExecutionException("Метод " + method.getName() + " повинен повертати void.");
                }
                if (method.getParameterCount() > 0) {
                    throw new StepExecutionException("Метод " + method.getName() + " не повинен приймати аргументів.");
                }

                stepMethods.add(method);
            }
        }

        stepMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Step.class).order()));

        for (Method method : stepMethods) {
            method.setAccessible(true);

            try {
                System.out.println("Виконання кроку: " + method.getName());
                method.invoke(target);

            } catch (IllegalAccessException e) {
                throw new StepExecutionException("Немає доступу до методу: " + method.getName(), e);

            } catch (InvocationTargetException e) {
                throw new StepExecutionException("Помилка під час виконання методу: " + method.getName(), e.getCause());
            }
        }
    }
}
