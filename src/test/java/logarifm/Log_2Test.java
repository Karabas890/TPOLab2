package logarifm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log_2Test {

    @Test
    void testLog_2_ValidInput() {
        double epsilon = 1e-5;
        double x = 8.0;

        // Вызываем метод log_2
        Log_2 log2 = new Log_2();
        double result = log2.log_2(x, epsilon);

        // Ожидаем, что log_2(8) будет равно 3, так как ln(8) / ln(2) = 3
        assertEquals(3.0, result, epsilon);
    }

    @Test
    void testLog_2_InputEquals1() {
        double epsilon = 1e-5;
        double x = 1.0;

        // Вызываем метод log_2
        Log_2 log2 = new Log_2();
        double result = log2.log_2(x, epsilon);

        // Ожидаем, что log_2(1) будет 0, так как ln(1) / ln(2) = 0
        assertEquals(0.0, result, epsilon);
    }

    @Test
    void testLog_2_NegativeInput_ShouldThrow() {
        double epsilon = 1e-5;
        double x = -8.0;

        // Проверяем, что при отрицательном значении x выбрасывается исключение
        Log_2 log2 = new Log_2();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            log2.log_2(x, epsilon);
        });

        assertTrue(exception.getMessage().contains("ln неопределен для этого x"));
    }

    @Test
    void testLog_2_SmallInput() {
        double epsilon = 1e-5;
        double x = 1.1;

        // Вызываем метод log_2
        Log_2 log2 = new Log_2();
        double result = log2.log_2(x, epsilon);

        // Ожидаем, что log_2(1.1) будет примерно 0.137503
        assertEquals(0.137503, result, epsilon);
    }
}
