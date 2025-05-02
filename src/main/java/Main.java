import logarifm.*;
import mainFunction.Function;
import trigonometry.*;
public class Main {
    public static void main(String[] args) {
        double start = -10;
        double end = 10;
        double step = 0.001;
        double epsilon = 1e-6;
        String separator = ";";

        // Пример 1: логарифм
        CsvExporter.exportToCsv(
                "ln_output.csv",
                Ln::ln,
                start, end, step, epsilon,
                separator
        );
        // Пример 2: логарифм2
        CsvExporter.exportToCsv(
                "log2_output.csv",
                Log_2::log_2,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "log3_output.csv",
                Log_3::log_3,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "log5_output.csv",
                Log_5::log_5,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "log10_output.csv",
                Log_10::log_10,
                start, end, step, epsilon,
                separator
        );

        // Пример 3: синус
        CsvExporter.exportToCsv(
                "sin_output.csv",
                Sin::sin,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "cos_output.csv",
                Cos::cos,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "tan_output.csv",
                Tan::tan,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "cot_output.csv",
                Cot::cot,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "Csc_output.csv",
                Csc::csc,
                start, end, step, epsilon,
                separator
        );
        CsvExporter.exportToCsv(
                "Sec_output.csv",
                Sec::sec,
                start, end, step, epsilon,
                separator
        );

        // Пример 4: f(x)
        CsvExporter.exportToCsv(
                "f_output.csv",
                Function::f,
                start, end, step, epsilon,
                separator
        );
    }
}
