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

            User savedUser = userRepository.save(existingUser);  // Fixed typo
            return ResponseEntity.ok(savedUser);
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
}

    
    //Adding a user
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        if(user.getUsername() == null || user.getPassword() == null || user.getRole() == null){
            return ResponseEntity.badRequest().body("All fields are required: Username, password and role.");
            
        }
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
    
}
