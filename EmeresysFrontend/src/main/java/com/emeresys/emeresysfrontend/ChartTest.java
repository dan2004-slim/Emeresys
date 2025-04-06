/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

/**
 *
 * @author USER
 */
public class ChartTest {
    public static void main(String[] args){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 40);
        dataset.setValue("Category 2", 30);
        dataset.setValue("Category 3", 20);
        
        
        JFreeChart pieChart = ChartFactory.createPieChart("Test Chart",dataset,true,true,false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
    
}
