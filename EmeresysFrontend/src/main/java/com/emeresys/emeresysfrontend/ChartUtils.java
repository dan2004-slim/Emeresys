/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

/**
 *
 * @author USER
 */
public class ChartUtils {
    
    public static ChartPanel createPieChart(String title, String[] categories, int[] values ){
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i<categories.length; i++){
            dataset.setValue(categories[i], values[i]);
        }
        JFreeChart chart = ChartFactory.createPieChart(title, dataset,true, true, false);
        return new ChartPanel(chart);
    }
    
        public static ChartPanel createBarChart(String title, String categoryAxis, String valueAxis ,String[] categories,int[] values ){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i<categories.length; i++){
            dataset.addValue(values[i], categoryAxis, categories[i] );
        }
        JFreeChart chart = ChartFactory.createBarChart(title, categoryAxis,valueAxis,dataset);
        return new ChartPanel(chart);
    }
        
        public static ChartPanel createLineChart(String title, String categoryAxis, String valueAxis ,String[] categories,int[] values ){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i<categories.length; i++){
            dataset.addValue(values[i], "Series1", categories[i] );
        }
        JFreeChart chart = ChartFactory.createLineChart(title, categoryAxis,valueAxis,dataset);
        return new ChartPanel(chart);
    }
        //Test case
        public static void main(String[] args){
            SwingUtilities.invokeLater(()->{
                   JFrame frame = new JFrame("Chart Test Case");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Arrange charts vertically

            // Example data
            String[] categories = {"Category 1", "Category 2", "Category 3"};
            int[] values = {40, 30, 30};

            // Add charts using ChartUtils
            frame.add(createPieChart("Test Pie Chart", categories, values));
            frame.add(createBarChart("Test Bar Chart", "Categories", "Values", categories, values));
            frame.add(createLineChart("Test Line Chart", "Time", "Values", categories, values));

            frame.setVisible(true);
            });
        }
    
    
}
