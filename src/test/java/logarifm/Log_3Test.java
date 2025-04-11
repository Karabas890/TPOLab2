package logarifm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log_3Test {

    @Test
    void testLog_3_ValidInput() {
        double epsilon = 1e-5;
        double x = 9.0;

        // Вызываем метод log_3
        Log_3 log3 = new Log_3();
        double result = log3.log_3(x, epsilon);

        // Ожидаем, что log_3(9) будет равно 2, так как ln(9) / ln(3) = 2
        assertEquals(2.0, result, epsilon);
    }

    @Test
    void testLog_3_InputEquals1() {
        double epsilon = 1e-5;
        double x = 1.0;

        // Вызываем метод log_3
        Log_3 log3 = new Log_3();
        double result = log3.log_3(x, epsilon);

        // Ожидаем, что log_3(1) будет 0, так как ln(1) / ln(3) = 0
        assertEquals(0.0, result, epsilon);
    }

    @Test
    void testLog_3_NegativeInput_ShouldThrow() {
        double epsilon = 1e-5;
        double x = -9.0;

        // Проверяем, что при отрицательном значении x выбрасывается исключение
        Log_3 log3 = new Log_3();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            log3.log_3(x, epsilon);
        });

        assertTrue(exception.getMessage().contains("ln неопределен для этого x"));
    }

    @Test
    void testLog_3_SmallInput() {
        double epsilon = 1e-5;
        double x = 1.2;

        // Вызываем метод log_3
        Log_3 log3 = new Log_3();
        double result = log3.log_3(x, epsilon);

        // Ожидаем, что log_3(1.2) будет примерно 0,165956
        assertEquals(0.165956, result, epsilon);
    }
}
