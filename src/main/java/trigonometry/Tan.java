package trigonometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static trigonometry.Cos.cos;


public class Tan {
    public static double tan(double x,double epsilon) {
        if (cos(x,epsilon) == 0) throw new IllegalArgumentException("Функция не существует в точке x=" + x);
        BigDecimal bd = BigDecimal.valueOf(Sin.sin(Sin.sin(x,epsilon) / cos(x,epsilon),epsilon)).setScale(5, RoundingMode.HALF_UP);
        //return bd.doubleValue();
        return (Sin.sin(x,epsilon) / cos(x,epsilon));
    }
}