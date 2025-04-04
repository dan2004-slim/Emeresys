/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.model;

/**
 *
 * @author USER
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "resource")

public class Resources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;
    
    @NotBlank(message = "resource type is required")
    private String resourceType;
    
    @NotBlank(message = "Status is required")
    private String status;
    
    @Min(value = 1, message = "Location ID must be positive")
    private int locationId;
    
    @Min(value = 1, message = "Resource Type ID must be positive")
    private int resourceTypeId;
    
    // Default resources constructor
    public Resources(){}
    
    // constructor with parameters
    public Resources(String resourceType, String status,
            int locationId, int resourceTypeId){
        
        this.resourceType = resourceType;
        this.status = status;
        this.locationId = locationId;
        this.resourceTypeId = resourceTypeId;
    }
    
    // resource getters and setters 
    
    public Long getResourceId(){return resourceId;}
    public void setResourceId(Long resourceId){this.resourceId = resourceId;}
    
    public String getResourceType(){return resourceType;}
    public void setResourceType(String resourceType){this.resourceType = resourceType;}
    
    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}
    
    public int getLocationId(){return locationId;}
    public void setLocationId(int locationId){this.locationId = locationId;}
    
    public int getResourceTypeId(){return resourceTypeId;}
    public void setResourceTypeId(int resourceTypeId){this.resourceTypeId = resourceTypeId;}
    
}
