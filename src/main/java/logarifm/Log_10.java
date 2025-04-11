package logarifm;


import static logarifm.Ln.ln;

public class Log_10 {
    public static double log_10(double x, double epsilon) {
        return ln(x,epsilon) / ln(10.0,epsilon);
    }

}