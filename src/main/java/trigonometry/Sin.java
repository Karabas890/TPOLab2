package trigonometry;

public class Sin {

    /**
     * Вычисление синуса с заданной точностью (погрешностью) epsilon.
     *
     * @param x       входное значение (в радианах)
     * @param epsilon допустимая погрешность (например, 1e-5)
     * @return значение sin(x) с точностью до epsilon
     */
    public static double sin(double x, double epsilon) {
        epsilon /= 2;
        x = x % (2 * Math.PI);  // Нормализация значения x

        double result = 0;
        double term = x;
        int n = 1;

        int iterations = 0;
        while (Math.abs(term) >= epsilon && iterations < 1000) {
            result += term;
            term *= -x * x / ((2 * n) * (2 * n + 1));
            n++;
            iterations++;
        }

        return result;
    }
}
