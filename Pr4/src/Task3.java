public class Task3 {
    public static void main(String[] args) {
        Animal a = new Dog("Patron");
        Animal b = new Cat("Mars");

        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.fetchStick();
        }

        if (b instanceof Dog) {
            Dog d = (Dog) b;
            d.fetchStick();
        } else {
            System.out.println("Object b is not dog.");
        }

        /* Спроба привести Кота до Собаки без перевірки.
        Це скомпілюється, бо Cat і Dog - це Animal
        але під час ВИКОНАННя виб'є ClassCastException
         */
    }
}
