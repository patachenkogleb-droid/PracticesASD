import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testDivideSuccess() {
        int expected = 5;
        int actual = calculator.divide(10, 2);

        assertEquals(expected, actual, "10 : 2 має бути 5");
    }

    @Test
    void testDivideByZero() {

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Має вибити IllegalArgumentException при діленні на 0");
    }
}
