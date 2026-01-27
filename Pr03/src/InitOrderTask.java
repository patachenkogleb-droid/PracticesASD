class BaseInit {
    static {
        System.out.println("Base: Статичний блок");
    }

    {
        System.out.println("Base: Instance блок");
    }

    public BaseInit() {
        System.out.println("Base: Конструктор");
    }
}

class ChildInit extends BaseInit {
    static {
        System.out.println("Child: Статичний блок");
    }

    {
        System.out.println("Child: Instance блок");
    }

    public ChildInit() {
        System.out.println("Child: Конструктор");
    }
}

public class InitOrderTask {
    public void run() {
        new ChildInit();
    }

    public static void main(String[] args) {
        new InitOrderTask().run();
    }
}
