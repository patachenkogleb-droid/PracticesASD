package Task1;

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name;
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String toString() {
        return super.toString() + ", Breed: " + breed;
    }
}

class Cat extends Animal {
    String breed;

    public Cat(String name, String breed) {
        super(name);
        this.breed = breed;
    }
}

public class Task1 {
    public static void main(String[] args) {
        Dog dog = new Dog("Rex", "German Shepherd");
        System.out.println(dog);
    }
}

/*
Властивість breed має належати класам Dog і Cat, а не класу Animal, адже не всі тварини мають породу.
І якщо цю властивість дати класу Animal, то для деяких його екземплярів (скажімо, Crocodile) вона не буде мати сенсу.
 */