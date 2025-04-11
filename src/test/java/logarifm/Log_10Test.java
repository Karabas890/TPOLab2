package logarifm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log_10Test {

    @Test
    void testLog_10_ValidInput() {
        double epsilon = 1e-5;
        double x = 100.0;

        // Вызываем метод log_10
        Log_10 log10 = new Log_10();
        double result = log10.log_10(x, epsilon);

        // Ожидаем, что log_10(100) будет равно 2, так как ln(100) / ln(10) = 2
        assertEquals(2.0, result, epsilon);
    }

    @Test
    void testLog_10_InputEquals1() {
        double epsilon = 1e-5;
        double x = 1.0;

        // Вызываем метод log_10
        Log_10 log10 = new Log_10();
        double result = log10.log_10(x, epsilon);

        // Ожидаем, что log_10(1) будет 0, так как ln(1) / ln(10) = 0
        assertEquals(0.0, result, epsilon);
    }

    @Test
    void testLog_10_NegativeInput_ShouldThrow() {
        double epsilon = 1e-5;
        double x = -100.0;

        // Проверяем, что при отрицательном значении x выбрасывается исключение
        Log_10 log10 = new Log_10();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            log10.log_10(x, epsilon);
        });

        assertTrue(exception.getMessage().contains("ln неопределен для этого x"));
    }

    @Test
    void testLog_10_SmallInput() {
        double epsilon = 1e-5;
        double x = 1.1;

        // Вызываем метод log_10
        Log_10 log10 = new Log_10();
        double result = log10.log_10(x, epsilon);

        // Ожидаем, что log_10(1.1) будет примерно 0,041393
        assertEquals(0.041393, result, epsilon);
    }
}
