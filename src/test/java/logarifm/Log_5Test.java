package logarifm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log_5Test {

    @Test
    void testLog_5_ValidInput() {
        double epsilon = 1e-5;
        double x = 25.0;

        // Вызываем метод log_5
        Log_5 log5 = new Log_5();
        double result = log5.log_5(x, epsilon);

        // Ожидаем, что log_5(25) будет равно 2, так как ln(25) / ln(5) = 2
        assertEquals(2.0, result, epsilon);
    }

    @Test
    void testLog_5_InputEquals1() {
        double epsilon = 1e-5;
        double x = 1.0;

        // Вызываем метод log_5
        Log_5 log5 = new Log_5();
        double result = log5.log_5(x, epsilon);

        // Ожидаем, что log_5(1) будет 0, так как ln(1) / ln(5) = 0
        assertEquals(0.0, result, epsilon);
    }

    @Test
    void testLog_5_NegativeInput_ShouldThrow() {
        double epsilon = 1e-5;
        double x = -25.0;

        // Проверяем, что при отрицательном значении x выбрасывается исключение
        Log_5 log5 = new Log_5();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            log5.log_5(x, epsilon);
        });

        assertTrue(exception.getMessage().contains("ln неопределен для этого x"));
    }

    @Test
    void testLog_5_SmallInput() {
        double epsilon = 1e-5;
        double x = 1.1;

        // Вызываем метод log_5
        Log_5 log5 = new Log_5();
        double result = log5.log_5(x, epsilon);

        // Ожидаем, что log_5(1.1) будет примерно 0,05922
        assertEquals(0.05922, result, epsilon);
    }
}
