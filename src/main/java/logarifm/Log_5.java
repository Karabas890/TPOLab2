package logarifm;

import static logarifm.Ln.ln;

public class Log_5 {
    public static double log_5(double x, double epsilon) {
        return ln(x,epsilon) / ln(5.0,epsilon);
    }

}
