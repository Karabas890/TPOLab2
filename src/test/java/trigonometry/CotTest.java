package trigonometry;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CotTest {

    @Test
    void testCot_PositiveAngle() {
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class)
        ) {
            double x = Math.PI / 4;
            double epsilon = 1e-5;

            // sin(x) ≈ 0.7071, cos(x) ≈ 0.7071
            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(0.7071);
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.7071);

            double result = Cot.cot(x, epsilon);
            assertEquals(1.0, result, 0.01);
        }
    }

    @Test
    void testCot_NegativeAngle() {
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class)
        ) {
            double x = -Math.PI / 4;
            double epsilon = 1e-5;

            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(-0.7071);
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.7071);

            double result = Cot.cot(x, epsilon);
            assertEquals(-1.0, result, 0.01);
        }
    }

    @Test
    void testCot_SinZero_ShouldThrow() {
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class)
        ) {
            double x = Math.PI;
            double epsilon = 1e-5;

            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(0.0);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Cot.cot(x, epsilon);
            });

            assertTrue(exception.getMessage().contains("Функция не существует"));
        }
    }
}
