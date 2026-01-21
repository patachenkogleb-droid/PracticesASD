package Task2;

import java.util.Objects;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }
}

public class Task2 {
    public static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println("String ==: " + (s1 == s2));
        System.out.println("String equals: " + s1.equals(s2));

        for (int i = -128; i <= 127; i++) {
            Integer a = i;
            Integer b = i;
            if (a != b) {
                System.out.println("Diff references for: " + i);
            }
        }


        Dog dog1 = new Dog("Rex", "Labrador");
        Dog dog2 = new Dog("Rex", "Labrador");
        Dog dog3 = new Dog("Rex", "Pug");

        System.out.println("Dog1 equals Dog2: " + dog1.equals(dog2));
        System.out.println("Dog1 equals Dog3: " + dog1.equals(dog3));
    }
}

        /* Висновок
        Оператор == порівнює посилання на об'єкти, тому s1 == s2 повертає false
        Метод equals() порівнює логічний зміст об'єктів. Тому s1.equals(s2) повертає true
        Для Integer в діапазоні від -128 до 127 Java використовує кешування(
        Тому при порівнянні через == об'єкти з цього діапазону мають одне й те саме посилання
        Поза цим діапазоном (наприклад, 128) створюються нові об'єкти, == поверне false.
        */

