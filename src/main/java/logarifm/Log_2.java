package logarifm;


import static logarifm.Ln.ln;

public class Log_2 {
    public static double log_2(double x,double epsilon) {
        return ln(x,epsilon) / ln(2.0,epsilon);
    }
}