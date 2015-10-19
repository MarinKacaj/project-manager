package main.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;

import java.awt.*;

/**
 * Created by Marin KaÃ§aj on 10/6/2015. Builds a Gantt chart.
 */
public class GanttChartBuilder {

    private String title;
    private String xLabel;
    private String yLabel;

    public GanttChartBuilder(String title, String xLabel, String yLabel) {
        this.title = title;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }

    public ChartPanel buildChartPanel(IntervalCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createGanttChart(title, xLabel, yLabel, dataSet, false, true, false);
        chart.setBackgroundPaint(new Color(244, 244, 244));

        LegendTitle legend = new LegendTitle(chart.getPlot());
        legend.setBorder(0, 0, 0, 0);
        legend.setPosition(RectangleEdge.BOTTOM);
        legend.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
        legend.setPadding(new RectangleInsets(15.0, 100.0, 1.0, 1.0));
        chart.addLegend(legend);

        CategoryPlot plot = chart.getCategoryPlot();
        ((GanttRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter());

        plot.setBackgroundPaint(new Color(250, 250, 210));
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(new Color(227, 227, 227));
        plot.setRangeGridlineStroke(new BasicStroke(1.5F));

        CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(250, 102, 54));
        renderer.setSeriesPaint(1, new Color(104, 171, 102));

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(1100, 400));

        return panel;
    }
}