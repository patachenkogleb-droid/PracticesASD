abstract class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void speak();
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Dog " + getName() + " says 'Woof'.");
    }

    public void fetchStick(){
        System.out.println("Dog " + getName() + " is fetching stick.");
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println("Cat " + getName() + " says 'Meow'.");
    }
}

public class Task1 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Rex"),
                new Cat("Mars"),
                new Dog("Patron"),
                new Cat("Tom")
        };

        for (Animal animal : animals) {
            animal.speak();
        }
    }
}