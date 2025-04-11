package logarifm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    @Test
    void testLn_ValidInput_AboveZero() {
        double x = 2.0;
        double epsilon = 1e-5;

        // Используем Math.log(x) для сравнения
        double expected = Math.log(x);
        double result = Ln.ln(x, epsilon);

        assertEquals(expected, result, epsilon);
    }

    @Test
    void testLn_EqualTo1() {
        double x = 1.0;
        double epsilon = 1e-5;

        // ln(1) всегда 0.0
        double expected = Math.log(x);
        double result = Ln.ln(x, epsilon);

        assertEquals(expected, result, epsilon);
    }

    @Test
    void testLn_ZeroInput_ShouldThrow() {
        double x = 0.0;
        double epsilon = 1e-5;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Ln.ln(x, epsilon);
        });

        assertTrue(exception.getMessage().contains("ln неопределен для этого x"));
    }

    @Test
    void testLn_NegativeInput_ShouldThrow() {
        double x = -1.0;
        double epsilon = 1e-5;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Ln.ln(x, epsilon);
        });

        assertTrue(exception.getMessage().contains("ln неопределен для этого x"));
    }

    @Test
    void testLn_SmallEpsilon() {
        double x = 2.0;
        double epsilon = 1e-10;

        // Используем Math.log(x) для сравнения
        double expected = Math.log(x);
        double result = Ln.ln(x, epsilon);

        assertEquals(expected, result, epsilon);
    }

    @Test
    void testLn_LargeEpsilon() {
        double x = 2.0;
        double epsilon = 1e-1; // Большой epsilon

        // Используем Math.log(x) для сравнения
        double expected = Math.log(x);
        double result = Ln.ln(x, epsilon);

        assertEquals(expected, result, epsilon);
    }

    @Test
    void testLn_LargeInput() {
        double x = 1000.0;
        double epsilon = 1e-5;

        // Используем Math.log(x) для сравнения
        double expected = Math.log(x);
        double result = Ln.ln(x, epsilon);

        assertEquals(expected, result, epsilon);
    }

    @Test
    void testLn_SmallInput() {
        double x = 1.1;
        double epsilon = 1e-5;

        // Используем Math.log(x) для сравнения
        double expected = Math.log(x);
        double result = Ln.ln(x, epsilon);

        assertEquals(expected, result, epsilon);
    }


}
