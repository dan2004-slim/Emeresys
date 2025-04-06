/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.service;

/**
 *
 * @author USER
 */

import com.example.DisasterResponseBackend.model.Resources;
import com.example.DisasterResponseBackend.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;
    
    // gets and stores all resources by making the call to ResourceRepository
    public List<Resources> getAllResources(){
        return resourceRepository.findAll();
    }
    
    
    public Optional<Resources> getResourceByResourceType(String resourceType){
        return resourceRepository.findByResourceType(resourceType);
    }
    
    public Resources saveResource (Resources resource){
        return resourceRepository.save(resource);
    }
}
