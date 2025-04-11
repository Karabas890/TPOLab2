package trigonometry;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CosTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testCos_Zero() {
        assertCosWithMock(0.0);
    }

    @Test
    public void testCos_PositiveAngle() {
        assertCosWithMock(Math.PI / 3);
    }

    @Test
    public void testCos_NegativeAngle() {
        assertCosWithMock(-Math.PI / 4);
    }

    @Test
    public void testCos_AtPi() {
        assertCosWithMock(Math.PI);
    }

    @Test
    public void testCos_At2Pi() {
        assertCosWithMock(2 * Math.PI);
    }

    @Test
    public void testCos_AtMinus2Pi() {
        assertCosWithMock(-2 * Math.PI);
    }

    @Test
    public void testCos_Infinity() {
        double x = Double.POSITIVE_INFINITY;
        double sinArg = Math.PI / 2 - x;

        try (MockedStatic<Sin> sinMock = mockStatic(Sin.class)) {
            sinMock.when(() -> Sin.sin(sinArg, EPSILON)).thenReturn(Double.NaN);

            double result = Cos.cos(x, EPSILON);
            assertTrue(Double.isNaN(result));
        }
    }

    @Test
    public void testCos_NaN() {
        double x = Double.NaN;
        double sinArg = Math.PI / 2 - x;

        try (MockedStatic<Sin> sinMock = mockStatic(Sin.class)) {
            sinMock.when(() -> Sin.sin(sinArg, EPSILON)).thenReturn(Double.NaN);

            double result = Cos.cos(x, EPSILON);
            assertTrue(Double.isNaN(result));
        }
    }

    //Вспомогательный метод для обычных значений
    private void assertCosWithMock(double x) {
        double expected = Math.cos(x);
        double sinArg = Math.PI / 2 - x;

        try (MockedStatic<Sin> sinMock = mockStatic(Sin.class)) {
            sinMock.when(() -> Sin.sin(sinArg, EPSILON)).thenReturn(Math.sin(sinArg));

            double result = Cos.cos(x, EPSILON);
            assertEquals(expected, result, EPSILON);

            sinMock.verify(() -> Sin.sin(sinArg, EPSILON), times(1));
        }
    }
}
