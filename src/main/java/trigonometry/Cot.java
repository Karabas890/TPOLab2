package trigonometry;


public class Cot {
    public static double cot(double x,double epsilon) {
        if (Sin.sin(x,epsilon) == 0) throw new IllegalArgumentException("Функция не существует в точке x=" + x);
        return Cos.cos(x,epsilon) / Sin.sin(x,epsilon);
    }
}