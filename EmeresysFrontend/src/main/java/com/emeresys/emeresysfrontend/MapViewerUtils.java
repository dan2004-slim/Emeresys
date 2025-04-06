/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import java.io.BufferedReader;
import org.json.JSONObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;

/**
 *
 * @author USER
 */
public class MapViewerUtils  {
    
    
        
       public static JMapViewer initializeMapViewer(int zoomLevel){
           
           //Create a JMapViewer instance
           JMapViewer mapViewer = new JMapViewer();
           
           //fetch location dynamically
           Coordinate myLocation = fetchLocation();
           if (myLocation != null){
               mapViewer.setDisplayPosition(myLocation, zoomLevel);
               
               MapMarkerDot bluePin = new MapMarkerDot("Your Location", myLocation);
               bluePin.getStyle().setBackColor(java.awt.Color.BLUE);
               bluePin.getStyle().setColor(java.awt.Color.BLUE);
               mapViewer.addMapMarker(bluePin);
           }
           
           //return MapViewer instance
           return mapViewer;
       }
        
        
    
    
    private static Coordinate fetchLocation(){
        try{
            //APi endpoint
            String apiUrl = "http://ip-api.com/json/";
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            
            String line;
            while ((line = reader.readLine())!= null){
                response.append(line);
            }
            reader.close();
            
            //Parese json RESPONSE
            JSONObject json = new JSONObject(response.toString());
            double latitude = json.getDouble("lat");
            double longitude = json.getDouble("lon");
            
            //return coordinates
            return new Coordinate(latitude, longitude);
            
        }
        catch(Exception e){
            e.printStackTrace();
            return new Coordinate(0.0, 0.0);// default location
        }
    }
    
    public static void main(String[] args){
        //Launch
        
        SwingUtilities.invokeLater(()->{
            JMapViewer viewer = initializeMapViewer(12);
            
            JFrame frame = new JFrame("Mapviewer Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.add(viewer);
            frame.setVisible(true);
        System.out.println("MapViewer initialized successfully");
        
        });
    }
    
}
