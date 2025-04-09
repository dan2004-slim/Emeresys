/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.emeresys.emeresysfrontend.ApiClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 *
 * @author USER
 */
public class NewsTicker extends JPanel {
    private JLabel tickerLabel;
    private String text = "Loading ALerts ...";
    private int position = 0;
    
    public NewsTicker(){
        tickerLabel = new JLabel(text);
        tickerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tickerLabel.setForeground(Color.BLACK);
        
        setLayout(new BorderLayout());
        add(tickerLabel,BorderLayout.CENTER);
        
        //scrolling animation
        Timer timer = new Timer(100, e->scrollText());
        timer.start();
        
        new Thread(this::loadAlerts).start();
    }
    
    private void scrollText(){
        position++;
        if (position > text.length()){
            position = 0;
        }
        tickerLabel.setText(text.substring(position)+" "+text.substring(0, position));
    }
    
    
private void loadAlerts(){
    try {

        ApiClient apiClient = new ApiClient();
        
        apiClient.getAlerts();
      

        
    } catch (Exception e) {
        e.printStackTrace();
        text = "Unable to fetch alerts!";
    }
}


    
}

