package trigonometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinTest {

    private static final double EPSILON = 1e-6;

    @Test
    public void testSinZero() {
        assertEquals(0.0, Sin.sin(0.0, EPSILON), EPSILON);
    }

    @Test
    public void testSinPiOverTwo() {
        assertEquals(1.0, Sin.sin(Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testSinPi() {
        assertEquals(0.0, Sin.sin(Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testSinThreePiOverTwo() {
        assertEquals(-1.0, Sin.sin(3 * Math.PI / 2, EPSILON), EPSILON);
    }

    @Test
    public void testSinTwoPi() {
        assertEquals(0.0, Sin.sin(2 * Math.PI, EPSILON), EPSILON);
    }

    @Test
    public void testSinNegativeX() {
        double x = -Math.PI / 4;
        assertEquals(Math.sin(x), Sin.sin(x, EPSILON), EPSILON);
    }

    @Test
    public void testSinLargeX() {
        double x = 20 * Math.PI + Math.PI / 3;
        assertEquals(Math.sin(x), Sin.sin(x, EPSILON), EPSILON);
    }

    @Test
    public void testSinSmallEpsilon() {
        double x = Math.PI / 4;
        double result = Sin.sin(x, 1e-15);
        assertEquals(Math.sin(x), result, 1e-15);
    }

    @Test
    public void testSinWithHighIterationCap() {
        // This indirectly checks the `iterations < 1000` limit isn't prematurely hit
        double x = 10;
        double result = Sin.sin(x, EPSILON);
        assertEquals(Math.sin(x), result, EPSILON);
    }
}
