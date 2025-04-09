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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


import javax.swing.*;
import java.awt.*;
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
        
        
    
    
  private static Coordinate fetchLocation() {
    try {
         String apiUrl = "http://ip-api.com/json/";

        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject json = new JSONObject(response.toString());
        JSONObject geometry = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry");
        double latitude = geometry.getDouble("lat");
        double longitude = geometry.getDouble("lng");

        return new Coordinate(latitude, longitude);
    } catch (Exception e) {
        e.printStackTrace();
        return new Coordinate(0.3334, 37.6500); // Default to Chuka
    }
}



    private static Coordinate refineWithOpenCage(Coordinate coarseLocation) {
    if (coarseLocation == null) return null;

    try {
        String apiKey = "YOUR_OPENCAGE_API_KEY"; // Replace with your OpenCage API key
        String query = coarseLocation.getLat() + "," + coarseLocation.getLon();
        String apiUrl = "https://api.opencagedata.com/geocode/v1/json?q=" + query + "&key=" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject json = new JSONObject(response.toString());
        JSONObject geometry = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry");
        double refinedLat = geometry.getDouble("lat");
        double refinedLon = geometry.getDouble("lng");

        return new Coordinate(refinedLat, refinedLon);
    } catch (Exception e) {
        e.printStackTrace();
        return coarseLocation; // Fallback to the coarse location if OpenCage fails
    }
}
public static Coordinate fetchAccurateLocation() {
    Coordinate initialLocation = fetchLocation(); // Fetch from ip-api
    if (initialLocation == null) {
        System.err.println("ip-api failed. Returning default location.");
        return new Coordinate(0.0, 0.0); // Default fallback
    }

    Coordinate refinedLocation = refineWithOpenCage(initialLocation); // Refine with OpenCage
    System.out.println("Accurate Location: " + refinedLocation);
    return refinedLocation;
}



public static List<String> parsePings(String pings) {
    // Split the pings by delimiter (e.g., commas, newlines, etc.)
    return List.of(pings.split(","));
}

    
   
 // Example usage
public static void getUserPings() {
    ApiClient apiClient = new ApiClient();
    
    // Get pings as a single String
    String pingsString = apiClient.getAllPings();

    // Parse the pings into a List
    List<String> allPings = parsePings(pingsString);

    // Now you can work with the List
    allPings.forEach(ping -> System.out.println("Ping: " + ping));
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
        
        
        // Add some yellow pings for testing
           addYellowPing(viewer, new Coordinate(0.3224, 49.6525)); // Example: Meru
            addYellowPing(viewer, new Coordinate(1.3334, 37.6500)); // Example: Tharaka
            System.out.println("MapViewer initialized successfully with red pings.");
            addRedPing(viewer, new Coordinate(-1.2864, 36.8172)); //Test SOS
        });
    }
    
        public static void addYellowPing(JMapViewer mapViewer, Coordinate location) {
        MapMarkerDot yellowMarker = new MapMarkerDot("High",location);
        yellowMarker.getStyle().setColor(Color.YELLOW); // Set marker color to yellow
        yellowMarker.getStyle().setBackColor(java.awt.Color.YELLOW);
        
        mapViewer.addMapMarker(yellowMarker);

        
        System.out.println("Yellow ping added at: " + location);
        // Refresh map
        mapViewer.revalidate();
        mapViewer.repaint();
    }
            public static void addRedPing(JMapViewer mapViewer, Coordinate location) {
    if (location != null) {
        MapMarkerDot redPin = new MapMarkerDot("SOS Ping", location);
        redPin.getStyle().setBackColor(java.awt.Color.RED);
        redPin.getStyle().setColor(java.awt.Color.RED);
        
        mapViewer.addMapMarker(redPin);
        System.out.println("Red ping added at: " + location);
    }
}
        






}
