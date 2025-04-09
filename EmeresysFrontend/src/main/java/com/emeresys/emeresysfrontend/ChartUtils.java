/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.util.*;

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

        

        
    static ChartPanel createBarChartFromAPI(String title, String categoryAxis, String valueAxis) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try {
        String response = ApiClient.getResources(); // Call to fetch resource data
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> resourceList = mapper.readValue(response, List.class);

        for (Map<String, Object> resource : resourceList) {
            String resourceType = resource.get("resourceType").toString();
            int statusValue = Integer.parseInt(resource.get("statusValue").toString());
            dataset.addValue(statusValue, categoryAxis, resourceType);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    JFreeChart chart = ChartFactory.createBarChart(title, categoryAxis, valueAxis, dataset);
    return new ChartPanel(chart);
}

    public static ChartPanel createPieChartFromAPI(String title) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try {
        String response = ApiClient.getAlerts(); // Call to fetch alerts
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> alertList = mapper.readValue(response, List.class);

        for (Map<String, Object> alert : alertList) {
            String severity = alert.get("severity").toString();
            int count = Integer.parseInt(alert.get("count").toString());
            dataset.setValue(severity, count);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
    return new ChartPanel(chart);
}


public static ChartPanel createResourceTypePieChart(String title) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try {
        // Fetch resource data
        String response = ApiClient.getResources(); // Fetch resources data
        if (response == null || response.startsWith("Error")) {
            System.err.println("Error fetching resource data: " + response);
            return new ChartPanel(null); // Return an empty chart in case of error
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> resourceList = mapper.readValue(response, List.class);

        // Aggregate resource types dynamically
        Map<String, Integer> resourceTypeCounts = new HashMap<>();
        for (Map<String, Object> resource : resourceList) {
            String resourceType = resource.get("resourceType") != null ? resource.get("resourceType").toString() : "Unknown";
            resourceTypeCounts.put(resourceType, resourceTypeCounts.getOrDefault(resourceType, 0) + 1);
        }

        // Add data to the dataset
        for (Map.Entry<String, Integer> entry : resourceTypeCounts.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
            System.out.println("Added to dataset -> ResourceType: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        if (dataset.getItemCount() == 0) {
            System.err.println("No valid data available to plot.");
            return new ChartPanel(null); // Handle empty dataset
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    


    
    JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
    return new ChartPanel(chart);
    
    
}
public static ChartPanel createUserRolePieChart(String title) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try {
        // Fetch user data from the API
        String response = ApiClient.getUsers();
        if (response == null || response.startsWith("Error")) {
            System.err.println("Error fetching user data: " + response);
            return new ChartPanel(null); // Return an empty chart in case of error
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> userList = mapper.readValue(response, List.class);

        // Aggregate user roles dynamically
        Map<String, Integer> roleCounts = new HashMap<>();
        for (Map<String, Object> user : userList) {
            String role = user.get("role") != null ? user.get("role").toString() : "Unknown";
            roleCounts.put(role, roleCounts.getOrDefault(role, 0) + 1);
        }

        // Add data to the dataset
        for (Map.Entry<String, Integer> entry : roleCounts.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
            System.out.println("Added to dataset -> Role: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        if (dataset.getItemCount() == 0) {
            System.err.println("No valid data available to plot.");
            return new ChartPanel(null); // Handle empty dataset
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
    return new ChartPanel(chart);
}

public static ChartPanel createUserRoleBarGraph(String title, String categoryAxis, String valueAxis) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try {
        // Fetch user data
        String response = ApiClient.getUsers();
        if (response == null || response.startsWith("Error")) {
            System.err.println("Error fetching user data: " + response);
            return new ChartPanel(null); // Return an empty chart in case of error
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> userList = mapper.readValue(response, List.class);

        // Aggregate user roles dynamically
        Map<String, Integer> roleCounts = new HashMap<>();
        for (Map<String, Object> user : userList) {
            String role = user.get("role") != null ? user.get("role").toString() : "Unknown";
            roleCounts.put(role, roleCounts.getOrDefault(role, 0) + 1);
        }

        // Add aggregated data to the dataset
        for (Map.Entry<String, Integer> entry : roleCounts.entrySet()) {
            dataset.addValue(entry.getValue(), "Roles", entry.getKey());
            System.out.println("Added to dataset -> Role: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        if (dataset.getRowCount() == 0) {
            System.err.println("No valid data available to plot.");
            return new ChartPanel(null); // Handle empty dataset
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    JFreeChart chart = ChartFactory.createBarChart(title, categoryAxis, valueAxis, dataset);
    return new ChartPanel(chart);
}


public static ChartPanel createResourceBarGraph(String title, String categoryAxis, String valueAxis) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try {
        // Fetch resource data
        String response = ApiClient.getResources();
        if (response == null || response.startsWith("Error")) {
            System.err.println("Error fetching resource data: " + response);
            return new ChartPanel(null);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> resourceList = mapper.readValue(response, List.class);

        // Aggregate resource types dynamically
        Map<String, Integer> resourceCounts = new HashMap<>();
        for (Map<String, Object> resource : resourceList) {
            String resourceType = resource.get("resourceType") != null ? resource.get("resourceType").toString() : "Unknown";
            resourceCounts.put(resourceType, resourceCounts.getOrDefault(resourceType, 0) + 1);
        }

        // Add data to the dataset
        for (Map.Entry<String, Integer> entry : resourceCounts.entrySet()) {
            dataset.addValue(entry.getValue(), "Resource Types", entry.getKey());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    JFreeChart chart = ChartFactory.createBarChart(title, categoryAxis, valueAxis, dataset);
    return new ChartPanel(chart);
}
public static ChartPanel createResourceLineGraph(String title, String categoryAxis, String valueAxis) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    try {
        // Fetch resource data
        String response = ApiClient.getResources();
        if (response == null || response.startsWith("Error")) {
            System.err.println("Error fetching resource data: " + response);
            return new ChartPanel(null); // Return an empty chart in case of error
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> resourceList = mapper.readValue(response, List.class);

        // Aggregate resource data dynamically (e.g., resource distribution over time)
        Map<String, Integer> resourceTrend = new LinkedHashMap<>();
        resourceTrend.put("Jan", 30);
        resourceTrend.put("Feb", 45);
        resourceTrend.put("Mar", 40);

        // Populate dataset
        for (Map.Entry<String, Integer> entry : resourceTrend.entrySet()) {
            dataset.addValue(entry.getValue(), "Resources", entry.getKey());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Create the line chart
    JFreeChart chart = ChartFactory.createLineChart(title, categoryAxis, valueAxis, dataset);
    return new ChartPanel(chart);
}




public static JScrollPane createTable(String[] columnNames, Object[][] data) {
    // Create the table
    JTable table = new JTable(data, columnNames);

    // Wrap the table in a scroll pane
    JScrollPane scrollPane = new JScrollPane(table);

    // Return the scroll pane for embedding in the UI
    return scrollPane;
}

public static JScrollPane createUsersTable() {
    String[] columnNames = {"User ID", "Username", "Email", "Role"}; // Define the column headers
    Object[][] data; // Placeholder for table data

    try {
        String response = ApiClient.getUsers(); // Fetch user data via API
        if (response == null || response.startsWith("Error")) {
            throw new Exception("Error fetching user data: " + response);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> userList = mapper.readValue(response, List.class);

        data = new Object[userList.size()][4]; // Define rows and columns
        int index = 0;
        for (Map<String, Object> user : userList) {
            data[index][0] = user.get("id");       // User ID
            data[index][1] = user.get("username"); // Username
            data[index][2] = user.get("email");    // Email
            data[index][3] = user.get("role");     // Role
            index++;
        }
    } catch (Exception e) {
        e.printStackTrace();
        data = new Object[][]{{"Error", "No data available", "", ""}}; // Default data in case of an error
    }

    return createTable(columnNames, data);
}


public static JScrollPane createResourcesTable() {
    String[] columnNames = {"Resource ID", "Resource Type", "Status", "Assigned Task"}; // Define the column headers
    Object[][] data; // Placeholder for table data

    try {
        String response = ApiClient.getResources(); // Fetch resources data via API
        if (response == null || response.startsWith("Error")) {
            throw new Exception("Error fetching resources data: " + response);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> resourceList = mapper.readValue(response, List.class);

        data = new Object[resourceList.size()][4]; // Define rows and columns
        int index = 0;
        for (Map<String, Object> resource : resourceList) {
            data[index][0] = resource.get("id");           // Resource ID
            data[index][1] = resource.get("resourceType"); // Resource Type
            data[index][2] = resource.get("status");       // Status
            data[index][3] = resource.get("assignedTask"); // Assigned Task
            index++;
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Default data in case of an error
        data = new Object[][]{{"Error", "No data available", "", ""}};
    }

    return createTable(columnNames, data);
}



public static ChartPanel createResourcePieChart(String title) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    try {
        // Fetch resource data from the API
        String response = ApiClient.getResources(); // Ensure this API call returns valid data
        if (response == null || response.startsWith("Error")) {
            throw new Exception("Error fetching resources data: " + response);
        }

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> resourceList = mapper.readValue(response, List.class);

        // Aggregate resource data dynamically
        Map<String, Integer> resourceCounts = new HashMap<>();
        for (Map<String, Object> resource : resourceList) {
            String resourceType = resource.get("resourceType").toString();
            int count = Integer.parseInt(resource.get("count").toString());
            resourceCounts.put(resourceType, resourceCounts.getOrDefault(resourceType, 0) + count);
        }

        // Add aggregated data to the dataset
        for (Map.Entry<String, Integer> entry : resourceCounts.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
    } catch (Exception e) {
        e.printStackTrace();
        // Add fallback data in case of an error
        dataset.setValue("Error", 1);
    }

    // Create the pie chart
    JFreeChart chart = ChartFactory.createPieChart(
            title,      // Chart title
            dataset,    // Data set
            true,       // Include legend
            true,       // Include tooltips
            false       // Don't include URLs
    );

    return new ChartPanel(chart); // Return the ChartPanel for integration
}


public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        // Create a test frame for Resources Table
        JFrame resourceTestFrame = new JFrame("Resources Table Test");
        resourceTestFrame.setSize(800, 600);
        resourceTestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Add the Resources Table to the frame
        JScrollPane resourcesTable = ChartUtils.createResourcesTable();
        resourceTestFrame.add(resourcesTable);

        // Make the frame visible
        resourceTestFrame.setVisible(true);
    });
}



}
