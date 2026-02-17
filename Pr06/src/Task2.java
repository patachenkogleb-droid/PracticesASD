public class Task2 {
    public static void main(String[] args) {
        // 1. Наслідування
        CheckoutService inheritedService = new LoggingCheckoutServiceInherited();
        System.out.println("Inheritance result: " + inheritedService.checkout("Order-101"));

        System.out.println("\n-----\n");

        // 2. Композиція
        CheckoutService originalService = new CheckoutService();
        LoggingCheckoutService compositionService = new LoggingCheckoutService(originalService);
        System.out.println("Composition result: " + compositionService.checkout("Order-102"));
    }
}

/*
Чому Композиція менш "крихка"?

 1. Легше комбінує функції
Якщо треба ще й кешування? Або тільки кешування?
- в наслідуванні треба створювати різні класи для кожної комбінації
- в композиції ми просто створюємо "матрьошку", комбінуючи функції як завгодно:
new LoggingCheckoutService(new CachingCheckoutService(new CheckoutService()));

2. Наслідування порушує інкапсуляцію. Клас-нащадок має доступ до protected полі
При композиції обгортка бачить тільки публічні методи оригіналу
Це безпечніше

3. Підміна реалізації на льоту
В наслідуванні вона вибирається один раз при компіляції
Не можна перетворити цей об'єкт назад на звичайний CheckoutService під час роботи програми
В композиції можна динамічно вирішувати, в яку обгортку загорнути сервіс залежно від налаштувань

 */