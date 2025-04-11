public class TestFunction {
    public static double f(double x, double epsilon) {
        epsilon /= 2; // Дополнительное уточнение точности

        // Когда x <= 0
        if (x <= 0) {
            double sin = Math.sin(x);
            double cos = Math.cos(x);
            double tan = Math.tan(x);
            double cot = 1 / tan;  // Котангенс как 1/tan
            double sec = 1 / cos;  // Секанс как 1/cos
            double csc = 1 / sin;  // Косеканс как 1/sin

            // Части выражения, разделенные для ясности
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

            // Возвращаем финальный результат для x <= 0
            return (((((((part3 - part4) / part5) + part6) * part7) * part8) / part10) * part11)
                    * (part14 - part15);
        } else {
            // Логарифмы для x > 0
            double log2 = Math.log(x) / Math.log(2);
            double log3 = Math.log(x) / Math.log(3);  // Для log_3
            double log5 = Math.log(x) / Math.log(5);
            double log10 = Math.log(x) / Math.log(10);

            // Возвращаем результат для x > 0
            return ((((log10 + log2) * log2) + log10) + Math.pow(log5, 2)) * log5;
        }
    }

    public static void main(String[] args) {
        // Пример вызова функции
        double result1 = f(0.5, 1e-5); // Для x <= 0
        System.out.println("Result when x <= 0: " + result1);

        double result2 = f(5, 1e-5);   // Для x > 0
        System.out.println("Result when x > 0: " + result2);
    }
}
