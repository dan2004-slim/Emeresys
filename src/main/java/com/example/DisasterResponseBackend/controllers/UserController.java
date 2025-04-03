/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.controllers;

import com.example.DisasterResponseBackend.model.User;
import com.example.DisasterResponseBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    
   @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    
    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username){
        return userService.getUserByUsername(username);
        
    }
    
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    
}
