package Task3;


class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating generic food.");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(name + " is eating meat.");
    }

    public void bark() {
        System.out.println("Woof-woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

public class Task3 {

    public static void feed(Animal animal) {
        System.out.println("Feeding " + animal.name);
        animal.eat();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bark();
        }
    }

    public static void main(String[] args) {
        Animal a = new Dog("Rex");
        Animal c = new Cat("Mars");

        feed(a);
        feed(c);
    }
}

/*
Висновок
Чому прямий downcast (наприклад, Dog d = (Dog) animal;) без перевірки instanceof є небезпечним?
Це може призвести до падіння програми.
Компілятор дозволяє таку дію, бо він бачить, що Dog є нащадком Animal.
JVM бачить реальний об'єкт у пам'яті.
Якщо в змінній animal насправді лежить Cat, а програміст намагається перетворити його на Dog, JVM зупиняє програму.
 */