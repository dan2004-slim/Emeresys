/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emeresys.emeresysfrontend;

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
            
            return content.asString();
        }
        
        catch(java.net.ConnectException e){
            //Handles offline backend
            return "Error: Unable to connect to the server.Please check backend is running";
            
        }
        catch(Exception e){
            
            e.printStackTrace();
            return "Error: An Unexpected error occures"+ e.getMessage();
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
    
    
}
