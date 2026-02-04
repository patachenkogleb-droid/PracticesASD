class A {
    public void process (Object obj){
        System.out.println("process (Object) from class A");
    }
}

class B extends A {

    @Override
    public void process (Object obj){
        System.out.println("process (Object) from class B");
    }

    public void process (String str){
        System.out.println(str);
    }
}
public class Task2 {
    public static void main (String[] args) {
        A a = new B();
        a.process("hi");
    }
}
