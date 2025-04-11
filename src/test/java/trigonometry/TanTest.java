package trigonometry;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TanTest {

    @Test
    void testTan_PositiveAngle() {
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class)
        ) {
            double x = Math.PI / 4;
            double epsilon = 1e-5;

            // cos(x) = sqrt(2)/2 ≈ 0.7071
            // sin(x) = sqrt(2)/2 ≈ 0.7071
            // tan(x) ≈ 1

            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(0.7071);
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.7071);

            double result = Tan.tan(x, epsilon);
            assertEquals(1.0, result, 0.01);
        }
    }

    @Test
    void testTan_NegativeAngle() {
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class)
        ) {
            double x = -Math.PI / 4;
            double epsilon = 1e-5;

            sinMock.when(() -> Sin.sin(x, epsilon)).thenReturn(-0.7071);
            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.7071);

            double result = Tan.tan(x, epsilon);
            assertEquals(-1.0, result, 0.01);
        }
    }

    @Test
    void testTan_CosZero_ShouldThrow() {
        try (
                MockedStatic<Sin> sinMock = mockStatic(Sin.class);
                MockedStatic<Cos> cosMock = mockStatic(Cos.class)
        ) {
            double x = Math.PI / 2;
            double epsilon = 1e-5;

            cosMock.when(() -> Cos.cos(x, epsilon)).thenReturn(0.0);

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Tan.tan(x, epsilon);
            });

            assertTrue(exception.getMessage().contains("Функция не существует"));
        }
    }
}
