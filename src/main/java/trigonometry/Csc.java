package trigonometry;


public class Csc {
    public static double csc(double x, double epsilon) {
        if (Sin.sin(x,epsilon) == 0) throw new IllegalArgumentException("Функция не существует в точке x=" + x);
        return 1.0 / Sin.sin(x,epsilon);
    }
}