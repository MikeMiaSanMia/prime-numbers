package com.recruitment.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PresentationService {
    private JPanel windowContent;
    private JPanel panel;
    private JButton button;

    public void showResults(List<Integer> list) {
        SwingUtilities.invokeLater(() -> {
            windowContent = new JPanel();
            BorderLayout borderLayout = new BorderLayout();
            windowContent.setLayout(borderLayout);
            panel = new JPanel();
            button = new JButton("Hello button");
            panel.add(button);
            button.addActionListener( (ActionEvent e) -> {
                        System.out.println("Hello");
                    });
            windowContent.add("North", panel);
            int listSize = list.size();
            double[] xAxisGenerator = generateXAxis(listSize);
            double[] solution = buildDoubleArray(list);
            JFrame frame = new JFrame("Prime Numbers Chart");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setContentPane(windowContent);
            XYDataset ds = createDataSet(xAxisGenerator, solution);
            JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                    "x - Number of Prime Numbers", "y - Prime Number Value",
                    ds, PlotOrientation.VERTICAL, true, true, false);

            ChartPanel cp = new ChartPanel(chart);

            frame.getContentPane().add(cp);
                }
        );
    }

    private XYDataset createDataSet(double[] xAxis , double[] solution) {
        DefaultXYDataset ds = new DefaultXYDataset();
        double[][] data = {xAxis, solution};
        ds.addSeries("series1", data);
        return ds;
    }

    private double[] generateXAxis(int end) {
        final int START = 1;
        List<Integer> range = IntStream.rangeClosed(START, end)
                .boxed().collect(Collectors.toList());
        return buildDoubleArray(range);
    }

    private double[] buildDoubleArray(List<Integer> list) {
        Integer[] dataArray = new Integer[list.size()];
        Integer[] integers = list.toArray(dataArray);
        return Arrays.stream(integers).mapToDouble(Integer::intValue).toArray();
    }
}
