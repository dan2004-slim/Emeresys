/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author USER
 */
public class NewsTicker extends JPanel {
    private JLabel tickerLabel;
    private String text = "Breaking News! DashBoard fully Operational! MapView Loaded Successfully! Alerts feature underway!";
    private int position = 0;
    
    public NewsTicker(){
        tickerLabel = new JLabel(text);
        tickerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tickerLabel.setForeground(Color.RED);
        
        setLayout(new BorderLayout());
        add(tickerLabel,BorderLayout.CENTER);
        
        //scrolling animation
        Timer timer = new Timer(100, e->scrollText());
        timer.start();
    }
    
    private void scrollText(){
        position++;
        if (position > text.length()){
            position = 0;
        }
        tickerLabel.setText(text.substring(position)+" "+text.substring(0, position));
    }
    
    //list to retrieve alerts
    public List<String> getAlerts(){
        
        return Arrays.asList(text.split("!"));
    }
    
}
