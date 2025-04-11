package trigonometry;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SecTest {

    @Test
    void testSec_PositiveAngle() {
        try (MockedStatic<Cos> cosMock = mockStatic(Cos.class)) {
            double x = Math.PI / 3;
            double epsilon = 1e-5;

            // cos(π/3) ≈ 0.5
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.5);

            double result = Sec.sec(x, epsilon);
            assertEquals(2.0, result, 0.01);
        }
    }

    @Test
    void testSec_NegativeAngle() {
        try (MockedStatic<Cos> cosMock = mockStatic(Cos.class)) {
            double x = -Math.PI / 3;
            double epsilon = 1e-5;

            // cos(-π/3) ≈ 0.5
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.5);

            double result = Sec.sec(x, epsilon);
            assertEquals(2.0, result, 0.01);
        }
    }

    @Test
    void testSec_ZeroCos_ShouldThrow() {
        try (MockedStatic<Cos> cosMock = mockStatic(Cos.class)) {
            double x = Math.PI / 2;
            double epsilon = 1e-5;

            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.0);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Sec.sec(x, epsilon);
            });

            assertTrue(exception.getMessage().contains("Функция не существует"));
        }
    }
}
