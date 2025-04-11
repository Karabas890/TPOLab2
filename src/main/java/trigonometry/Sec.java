package trigonometry;
public class Sec {
    public static double sec(double x, double epsilon) {
        if (Cos.cos(x,epsilon) == 0) throw new IllegalArgumentException("Функция не существует в точке x=" + x);
        return 1.0 / Cos.cos(x,epsilon);
    }
}