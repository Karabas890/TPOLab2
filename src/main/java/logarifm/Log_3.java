package logarifm;

import static logarifm.Ln.ln;

public class Log_3 {
    public static double log_3(double x, double epsilon) {
        return ln(x,epsilon) / ln(3.0,epsilon);
    }

}
