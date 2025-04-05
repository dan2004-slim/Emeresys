/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.controllers;
import com.example.DisasterResponseBackend.model.Resources;
import com.example.DisasterResponseBackend.service.ResourceService;
import com.example.DisasterResponseBackend.repository.ResourceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import jakarta.validation.Valid;
import java.util.*;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 *
 * @author USER
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    private final ResourceService resourceService;
    private final ResourceRepository resourceRepository;
    
    public ResourceController(ResourceRepository resourceRepository, ResourceService resourceService){
        this.resourceRepository = resourceRepository;
        this.resourceService = resourceService;
    }
    
    //get all resources
    @GetMapping
    public List<Resources> getAllResources(){
        return resourceService.getAllResources();
    }
    
    //getting a resource by its id
    @GetMapping("/{resourceId}")
    public ResponseEntity<Resources> getResourcesById(@PathVariable Long resourceId){
        System.out.println("Fetching resources by id" + resourceId);
        
        return resourceRepository.findById(resourceId)
                .map(resources -> {
                    System.out.println("Resource found "+ resources.getResourceType() );
                    return ResponseEntity.ok(resources);
                })
                .orElseGet(() -> {
                    System.out.println("Resource not found for id: "+ resourceId);
                    return ResponseEntity.notFound().build();
                });
    }
    
    //Getting  a resource by resourceType
    @GetMapping("/by-resourcetype/{resourceType}")
    public ResponseEntity<?> getResourceByResourceType(@PathVariable String resourceType){
        Optional<Resources> resource = resourceService.getResourceByResourceType(resourceType);
        return resource.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
        
    }
    
    //Adding a resource
    @PostMapping
    public ResponseEntity<?> createResource(@Valid @RequestBody Resources resource){
        if(resource.getResourceType() == null|| resource.getStatus() == null ||resource.getLocationId() == 0 || resource.getResourceTypeId() == 0 ){
            return ResponseEntity.badRequest().body("All fields are required: resourceType, status, locationId, resourceTypeId");
        }
        Resources savedResource = resourceService.saveResource(resource);
        return ResponseEntity.ok(savedResource);
    }
    
    //Deleting a resource by its id
    @DeleteMapping("/{resourceId}")
    public ResponseEntity<?> deleteResource(@PathVariable Long resourceId){
        System.out.println("Deleting resource with id: " +resourceId);
        
        return resourceRepository.findById(resourceId)
                .map(resource -> {
                    resourceRepository.delete(resource);
                    System.out.println("Resource deleted successfully");
                    return ResponseEntity.ok("Resource deleted successfully");
                })
                .orElseGet(()->{
                    System.out.println("Resource not found for id" +resourceId);
                    return ResponseEntity.notFound().build();
                });
    }
    
    //global error handler
    // collects  field name and messages from @Valid failures
    //returns a 400 Bad Request with a JSON listing validation error
    @RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}

    
    
    
    
    
}
