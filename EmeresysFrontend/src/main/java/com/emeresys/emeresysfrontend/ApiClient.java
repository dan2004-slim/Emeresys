/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/**
 *
 * @author USER
 */

import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Content;

import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.http.ContentType;


public class ApiClient {
    
    private static final String BASE_URL = "http://localhost:8080";
    
    
    //Login Method for users API
    public static String login(String identifier, String password){
        try{
            String jsonPayload = "{ \"identifier\": \"" +identifier+ "\", \"password\": \""+password+ "\"}";
            Content content = Request.post(BASE_URL+ "/users/login")
                    .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnContent();
            
            //Debug log for backend response
            String response = content.asString();
            System.out.println("Login Response: " + response);
            
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> responseMap = mapper.readValue(response, Map.class);
       
            
                    if (!responseMap.containsKey("id")) {
            System.err.println("Error: Key 'id' not found in response map.");
            return null; // Key doesn't exist
        }
            //Extract and return the userId from the response
          return responseMap.get("id");
            
        }
        
        catch(java.net.ConnectException e){
            //Handles offline backend
            
            System.err.println("Error in login"+e.getMessage());
            return null;
            
        }
        catch(Exception e){
            
            e.printStackTrace();
            System.err.println("Error in login"+e.getMessage());
            return null;
        }
    }
    
    
    
     //signUp Method for users API
    public static String signup(String username, String password, String role, String email){
        try{
            String jsonPayload = "{ \"username\": \"" +username+ "\", \"password\": \""+password+ "\", \"role\": \"" +role+ "\",\"email\": \"" +email+ "\" }";
            Content content = Request.post(BASE_URL+ "/users")
                    .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnContent();
            
            return content.asString();
        }
        catch(Exception e){
            
            e.printStackTrace();
            return "Error"+ e.getMessage();
        }
    }
    
    public static String fetchUsernameById(Long userId) {
    try {
        // Make GET request to fetch user details by ID
        Content content = Request.get(BASE_URL + "/users/" + userId)
                .execute()
                .returnContent();

        // Parse the response
        String response = content.asString();
        System.out.println("Fetch Username Response: " + response);

        JSONObject jsonResponse = new JSONObject(response);
        if (jsonResponse.has("username")) {
            return jsonResponse.getString("username");
        } else {
            System.err.println("Error: Username not found for user ID: " + userId);
            return null;
        }
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    
     // Get all resources (Resources API)
    public static String getResources() {
        try {
            Content content = Request.get(BASE_URL + "/resources")
                    .execute()
                    .returnContent();

            return content.asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    
       // Add a resource (Resources API)
    public static String addResource(String resourceType, String status, int locationId, int resourceTypeId) {
        try {
            String jsonPayload = "{ \"resourceType\": \"" + resourceType + "\", \"status\": \"" + status + "\", \"locationId\": " + locationId + ", \"resourceTypeId\": " + resourceTypeId + " }";
            Content content = Request.post(BASE_URL + "/resources")
                    .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnContent();

            return content.asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    
     public static String deleteResourceById(Long resourceId) {
        try {
            Content content = Request.delete(BASE_URL + "/resources/" + resourceId)
                    .execute()
                    .returnContent();

            return content.asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
     
      // Get all alerts (Alerts API)
    public static String getAlerts() {
        try {
            Content content = Request.get(BASE_URL + "/alerts")
                    .execute()
                    .returnContent();

            return content.asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    // Add a new alert (Alerts API)
    public static String addAlert(String message, String severity) {
        try {
            String jsonPayload = "{ \"message\": \"" + message + "\", \"severity\": \"" + severity + "\" }";
            Content content = Request.post(BASE_URL + "/alerts")
                    .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                    .execute()
                    .returnContent();

            return content.asString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    
    public static String updateUserIp(Long userId, String ipAddress) {
    try {
        //Fetching CurrentIp dynamically
        String currentIp = TempLocStorage.getCurrentIP();
        
        if(currentIp == null){
            return "Error: Unable to fetch current Ip address";
        }
        String jsonPayload = "{ \"ipAddress\": \"" + currentIp + "\" }";
        Content content = Request.put(BASE_URL + "/users/" + userId + "/ip")
                .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();
        
        
        String location = TempLocStorage.getLocation(ipAddress);
        System.out.println("Temporary Stored Location for IP: " + location);
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}
    

    public static String updateUserLocation(Long userId) {
    try {
        // Step 1: Fetch the user's current IP address
        String currentIp = TempLocStorage.getCurrentIP();
        if (currentIp == null) {
            return "Error: Unable to fetch current IP address.";
        }
        System.out.println("Current IP Address: " + currentIp);

        // Step 2: Fetch latitude and longitude using IP-API
        String apiUrl = "http://ip-api.com/json/" + currentIp;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
        reader.close();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(responseBuilder.toString());
        if (!"success".equals(jsonResponse.getString("status"))) {
            return "Error: " + jsonResponse.getString("message");
        }

        // Extract latitude and longitude
        Double latitude = jsonResponse.getDouble("lat");
        Double longitude = jsonResponse.getDouble("lon");
        System.out.println("Latitude: " + latitude + ", Longitude: " + longitude);

        // Step 3: Store location details in TempLocStorage
        TempLocStorage.storeLocationWithDetails(currentIp, latitude.toString(), longitude.toString());

        // Step 4: Simulate backend API call to update user location
        String jsonPayload = "{ \"latitude\": " + latitude + ", \"longitude\": " + longitude + " }";
        Content content = Request.put(BASE_URL + "/users/" + userId + "/location")
                .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();

        System.out.println("API Response: " + content.asString());
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

    
    
    
    public static String getAllPings() {
    try {
        Content content = Request.get(BASE_URL + "/pings")
                .execute()
                .returnContent();
        
        
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
    
}
    public static String getPingsByPriority(String priority) {
    try {
        Content content = Request.get(BASE_URL + "/pings/priority/" + priority)
                .execute()
                .returnContent();
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
    
    
}
public static String createPing(Long userId, String location, String priority) {
    try {
        String jsonPayload = "{ \"userId\": " + userId + ", \"location\": \"" + location + "\", \"priority\": \"" + priority + "\" }";
        Content content = Request.post(BASE_URL + "/pings")
                .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

public static String getPingsByUser(Long userId) {
    try {
        Content content = Request.get(BASE_URL + "/pings/user/" + userId)
                .execute()
                .returnContent();
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}
public static String getUserLocation(Long userId) {
    try {
        // Assume the backend API endpoint for fetching user location is /users/{userId}/location
        Content content = Request.get(BASE_URL + "/users/" + userId + "/location")
                .execute()
                .returnContent();

        return content.asString(); // Return the location as a string (latitude,longitude)
    } catch (Exception e) {
        e.printStackTrace();
        return "Error fetching user location: " + e.getMessage();
    }
}



// getting all users
public static String getUsers() {
    try {
        Content content = Request.get(BASE_URL + "/users") // Adjust the endpoint if necessary
                .execute()
                .returnContent();
        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}
   

public static String updateUser(Long userId, String username, String password, String role, String email) {
    try {
        String jsonPayload = "{ " +
                "\"username\": \"" + username + "\", " +
                "\"password\": \"" + password + "\", " +
                "\"role\": \"" + role + "\", " +
                "\"email\": \"" + email + "\"" +
                " }";
        Content content = Request.put(BASE_URL + "/users/" + userId)
                .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();
        
        
        System.out.println("Response: " + content.asString());
        System.out.println("Payload: " + jsonPayload);

        return content.asString();
        
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
    
    
}

public static String updateUserEmail(Long userId, String email) {
    try {
        String jsonPayload = "{ \"email\": \"" + email + "\" }";
        Content content = Request.put(BASE_URL + "/users/" + userId)
                .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();

        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}
public static String updateUserPassword(Long userId, String password) {
    try {
        String jsonPayload = "{ \"password\": \"" + password + "\" }";
        Content content = Request.put(BASE_URL + "/users/" + userId)
                .bodyString(jsonPayload, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();

        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}
public static String getUserRole(Long userId) {
    try {
        Content content = Request.get(BASE_URL + "/users/" + userId + "/role")
                .execute()
                .returnContent();

        return content.asString();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}


public static void main(String[] args) {
    // Example user ID to fetch
    Long userId = 14L; // Replace with an actual user ID from your backend
    
    try {
        // Call fetchUsernameById and print the result
        String username = ApiClient.fetchUsernameById(userId);
        if (username != null) {
            System.out.println("Fetched Username: " + username);
        } else {
            System.out.println("Failed to fetch username for User ID: " + userId);
        }
    } catch (Exception e) {
        System.err.println("Error occurred while fetching username: " + e.getMessage());
        e.printStackTrace();
    }
}



}


 

    

