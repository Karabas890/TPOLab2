import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvExporter {

    public static void exportToCsv(String filePath,
                                   FunctionViewer.MathFunctionWithEpsilon function,
                                   double start, double end, double step, double epsilon,
                                   String separator) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("X" + separator + "Result");

            for (double x = start; x <= end; x += step) {
                try {
                    double result = function.apply(x, epsilon);
                    if (Double.isFinite(result)) {
                        writer.printf("%.8f%s%.8f%n", x, separator, result);
                    } else {
                        writer.printf("%.8f%sNaN%n", x, separator);
                    }
                } catch (Exception e) {
                    writer.printf("%.8f%sError%n", x, separator);
                }
            }

            System.out.println("CSV файл успешно сохранён: " + filePath);

        } catch (IOException e) {
            System.err.println("Ошибка записи CSV файла: " + e.getMessage());
        }
    }
}
