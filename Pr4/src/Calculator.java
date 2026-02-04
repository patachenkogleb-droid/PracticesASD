public class Calculator {

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Ділити на нуль не можна.");
        }
        return a / b;
    }
}