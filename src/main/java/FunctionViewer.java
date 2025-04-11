
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import logarifm.*;
import trigonometry.*;


public class FunctionViewer {

    private static String path = "/Users/basti/Desktop/Functions"; // Путь к папке с графиками

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowChart("f(x) - основная система функций", Function::f, true, path);

            createAndShowChart("sin(x) - синус", Sin::sin, false, path);
            createAndShowChart("cos(x) - косинус", Cos::cos, false, path);
            createAndShowChart("tan(x) - тангенс", Tan::tan, true, path);
            createAndShowChart("cot(x) - котангенс", Cot::cot, true, path);
            createAndShowChart("sec(x) - секанс", Sec::sec, true, path);
            createAndShowChart("csc(x) - косеканс", Csc::csc, true, path);

            createAndShowChart("log_2(x) - логарифм по основанию 2", Log_2::log_2, false, path);
            createAndShowChart("log_3(x) - логарифм по основанию 3", Log_3::log_3, false, path);
            createAndShowChart("log_5(x) - логарифм по основанию 5", Log_5::log_5, false, path);
            createAndShowChart("log_10(x) - логарифм по основанию 10", Log_10::log_10, false, path);
        });
    }

    private static void createAndShowChart(String title, MathFunction function, boolean limitY, String imgDirPath) {
        XYSeries series = new XYSeries(title);

        double yLimit = 50;
        double start = -8.0;
        double end = 8;
        double step = 0.0011;

        for (double x = start; x <= end; x += step) {
            try {
                double y = function.apply(x);
                if (Double.isFinite(y)) {
                    if (limitY) {
                        if (y > yLimit) y = yLimit;
                        else if (y < -yLimit) y = -yLimit;
                    }
                    series.add(x, y);
                }
            } catch (Exception ignored) {
            }
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);

        if (imgDirPath != null) {
            try {
                String fileName = title.replaceAll("[^a-zA-Zа-яА-Я0-9\\-_. ]", "_") + ".png";
                File outputFile = new File(imgDirPath, fileName);

                File parentDir = outputFile.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    if (!parentDir.mkdirs()) {
                        throw new RuntimeException("Не удалось создать директорию: " + parentDir.getAbsolutePath());
                    }
                }

                ChartUtils.saveChartAsPNG(outputFile, chart, 800, 600);
            } catch (IOException e) {
                System.err.println("Ошибка сохранения: " + e.getMessage());
            }
        }

        ChartFrame frame = new ChartFrame(title, chart);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @FunctionalInterface
    public interface MathFunction {
        double apply(double x);
    }
}
