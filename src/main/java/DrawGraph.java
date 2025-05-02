import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DrawGraph {

    private static final String CSV_PATH = "f_output.csv"; // путь к файлу
    private static final String OUTPUT_DIR = "/Users/basti/Desktop/Functions"; // путь к папке для сохранения
    private static final double Y_AXIS_LIMIT = 100.0; // ограничение по оси Y

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            XYSeries series = readDataFromCSV(CSV_PATH);
            if (series != null) {
                createAndShowChart("f(x) из CSV", series, OUTPUT_DIR);
            }
        });
    }

    private static XYSeries readDataFromCSV(String filePath) {
        XYSeries series = new XYSeries("f(x)");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // пропускаем заголовок
                    continue;
                }

                String[] parts = line.split(";");
                if (parts.length != 2) continue;

                try {
                    double x = Double.parseDouble(parts[0].replace(',', '.'));
                    double y = Double.parseDouble(parts[1].replace(',', '.'));
                    if (Double.isFinite(y)) {
                        series.add(x, y);
                    }
                } catch (NumberFormatException ignored) {
                    // Пропускаем строку при ошибке парсинга
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        }

        return series;
    }

    private static void createAndShowChart(String title, XYSeries series, String imgDirPath) {
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

        // Установка ограничения по оси Y
        XYPlot plot = chart.getXYPlot();
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(-Y_AXIS_LIMIT, Y_AXIS_LIMIT); // от -Y до +Y

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
}
