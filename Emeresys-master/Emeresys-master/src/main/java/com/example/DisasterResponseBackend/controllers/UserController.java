/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.controllers;

import com.example.DisasterResponseBackend.model.User;
import com.example.DisasterResponseBackend.service.UserService;
import com.example.DisasterResponseBackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/users")
        

/**
 *
 * @author USER
 */
public class UserController {
    @Autowired
    private UserService userService;
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    //gets all users
   @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    
    
    //getting a user by Id but also added logging
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        
        System.out.println("fetching user with ID" +id);
        
    return userRepository.findById(id)
            .map(user -> {
                System.out.println("User found: "+ user.getUsername());
                return ResponseEntity.ok(user);
            })
            .orElseGet(() -> {
                System.out.println("User not found for ID: "+id);
                return ResponseEntity.notFound().build();
            });
    }
    
    //Getting a user by username
    @GetMapping("/by-username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
        
    }
    
    //Getting a user by email
    @GetMapping("/by-email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        
        if (email == null|| email.trim().isEmpty()){
         return ResponseEntity.badRequest().body("Email is required.");
        }
        return userRepository.findByEmail(email)
                .map(user ->{
                    System.out.println("User found with email: " +email);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(()->{
                    System.out.println("User not found for email: " +email);
                    return ResponseEntity.notFound().build();
                });
        
    }
    
    //Allows for updating users
    @PutMapping("/{id}")
public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    return userRepository.findById(id)
        .map(existingUser -> {
            if (updatedUser.getUsername() != null) {
                existingUser.setUsername(updatedUser.getUsername());
            }
            if (updatedUser.getPassword() != null) {
                existingUser.setPassword(updatedUser.getPassword());
            }
            if (updatedUser.getRole() != null) {
                existingUser.setRole(updatedUser.getRole());
            }
             if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }

            User savedUser = userRepository.save(existingUser);  // Fixed typo
            return ResponseEntity.ok(savedUser);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
}

    
    //Adding a user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(user.getUsername() == null || user.getPassword() == null || user.getRole() == null || user.getEmail() == null){
            return ResponseEntity.badRequest().body("All fields are required: Username, password , role and email.");
            
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
    
    //The login logic
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials){
        String identifier = credentials.get("identifier"); // can either be email or username
        String password = credentials.get("password");
        
        Optional<User> user = userRepository.findByUsername(identifier)
                .or(()-> userRepository.findByEmail(identifier));
        
        if (user.isPresent() && user.get().getPassword().equals(password)){
            System.out.println("Login Successful for user: " +user.get().getUsername());
            
            //including users role in the response
            String role = user.get().getRole();
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login Successful");
            response.put("role", role);
            
            return ResponseEntity.ok(response);
        }else{
            System.out.println("Invalid username or password for user: " +identifier);
            return ResponseEntity.status(401).body("Invalid username or password.");
        }
    }
    
    // Deleting a user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> { 
                    System.out.println("User found" +user.getUsername());
                    System.out.println("Deleting user:"+id);
                    userRepository.delete(user);
                    System.out.println("User with id"+id+"deleted successfully");
                    return ResponseEntity.ok("User with ID" +id+ " deleted successfully.");
                })
                .orElseGet(()->{
                   System.out.println("User not found for ID:"+id);
                   return ResponseEntity.notFound().build();
                });
                           
    }
    
    
    //Deleting Users using email
    @DeleteMapping("/by-email/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable String email){
        return userRepository.findByEmail(email)
                .map(user -> {
                    System.out.println("User found: " + user.getUsername());
                    System.out.println("Deleting User with email: "+email);
                    userRepository.delete(user);
                    System.out.println("User with email: "+email+ " deleted successfully: ");
                    return ResponseEntity.ok("User with email"+email+"deleted successfully");
                    
                })
                .orElseGet(()->{
                    System.out.println("User not found for email: "+email);
                    return ResponseEntity.notFound().build();
                });
        
    }
    
    
}
