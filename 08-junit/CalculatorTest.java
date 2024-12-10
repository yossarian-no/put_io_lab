package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp()
    {
        calculator = new Calculator();
    }

    @Test
    void test_add() {
        assertEquals(calculator.add(2, 2), 4);
        assertEquals(calculator.add(-1, 3), 2);
    }

    @Test
    void test_multiply() {
        assertEquals(calculator.multiply(2, 2), 4);
        assertEquals(calculator.multiply(-1, 3), -3);
    }

    @Test
    void test_addPositiveNumbers() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-2,3);
        });
    }
}
