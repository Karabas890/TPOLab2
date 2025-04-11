package mainFunction;

import logarifm.*;
import trigonometry.*;

public class Function {
    public static double f(double x,double epsilon) {
        epsilon /= 2;
        if (x <= 0) {

            double sin = Sin.sin(x,epsilon);
            double cos = Cos.cos(x,epsilon);
            double tan = Tan.tan(x,epsilon);
            double cot = Cot.cot(x,epsilon);
            double sec = Sec.sec(x,epsilon);
            double csc = Csc.csc(x,epsilon);

            double part1 = (((tan + cos) + tan) / (sec - sin)) * sec;
            double part2 = (part1 + tan + cot) * tan * (sin / csc);
            double part3 = Math.pow(part2, 3) / sec * Math.pow(cot, 2);
            double part4 = csc + (cos / cot);
            double part5 = ((sin / (tan + (sec / sec))) * csc) / (cos / (cot + tan));
            double part6 = ((cos + (sec + tan)) * (((sin * (cos * (csc - cot))) / tan) - Math.pow((cos / cos), 2))) / tan;
            double part7 = (csc - cos) / sin;
            double part8 = tan / sin;

            double part9 = Math.pow(((cot * sec) * (cot - Math.pow(cot, 2))), 3)
                    / (sec * (csc + cos)) - csc - cos;
            double part10 = part9 * sec / sin;
            double part11 = cot - sin;

            double part12_a = ((csc - csc) - cot) - (cot / cot);
            double part12_b = (tan / (Math.pow(((Math.pow(csc, 3) - cot) + (cos - sec)), 1)));
            double part12 = Math.pow((part12_a * Math.pow(part12_b, 3)), 1);

            double part13_a = (cos * Math.pow(((sec / Math.pow((sec / Math.pow(cot, 3)), 2)) + sec), 3));
            double part13 = (part13_a - tan) + (cos * cot);
            double part14 = Math.pow((part12 + part13), 2) + csc;

            double part15_num = (Math.pow(cos, 2) - Math.pow(cos, 3));
            double part15_den_inner = ((sin / tan) - cot) - (cos + sec);

            double part15_den_deep_inner = (sin + ((sin * cos) * sec));
            double part15_den_deep = Math.pow(part15_den_deep_inner, 3) * sec;

            double part15_den_deep_2 = (((csc + sin) + Math.pow(Math.pow(cos, 3), 2)) - tan)
                    + Math.pow(cos, 3);
            double part15_den_deep_3 = ((csc / ((cot - (sec + cot)) * (sec / cos))) * cot);

            double part15_den = part15_den_inner / (part15_den_deep - (part15_den_deep_2 * part15_den_deep_3));

            double part15 = part15_num / (csc * part15_den);

            return (((((((part3 - part4) / part5) + part6) * part7) * part8) / part10) * part11)
                    * (part14 - part15);
        } else {
            double log2 = Log_2.log_2(x,epsilon);
            double log3 = Log_3.log_3(x,epsilon); // Not used here, but maybe useful later
            double log5 = Log_5.log_5(x,epsilon);
            double log10 = Log_10.log_10(x,epsilon);

            return ((((log10 + log2) * log2) + log10) + Math.pow(log5, 2)) * log5;
        }
    }
}
