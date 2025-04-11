package trigonometry;



public class Cos {
    public static double cos(double x,double epsilon) {
        return Sin.sin(Math.PI / 2 - x,epsilon);
    }
}