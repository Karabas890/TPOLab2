package trigonometry;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CscTest {

    @Test
    void testCsc_PositiveAngle() {
        try (MockedStatic<Sin> sinMock = mockStatic(Sin.class)) {
            double x = Math.PI / 2;
            double epsilon = 1e-5;

            // sin(π/2) ≈ 1
            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(1.0);

            double result = Csc.csc(x, epsilon);
            assertEquals(1.0, result, 0.01);
        }
    }

    @Test
    void testCsc_NegativeAngle() {
        try (MockedStatic<Sin> sinMock = mockStatic(Sin.class)) {
            double x = -Math.PI / 2;
            double epsilon = 1e-5;

            // sin(-π/2) ≈ -1
            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(-1.0);

            double result = Csc.csc(x, epsilon);
            assertEquals(-1.0, result, 0.01);
        }
    }

    @Test
    void testCsc_ZeroSin_ShouldThrow() {
        try (MockedStatic<Sin> sinMock = mockStatic(Sin.class)) {
            double x = Math.PI;
            double epsilon = 1e-5;

            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(0.0);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Csc.csc(x, epsilon);
            });

            assertTrue(exception.getMessage().contains("Функция не существует"));
        }
    }
}
