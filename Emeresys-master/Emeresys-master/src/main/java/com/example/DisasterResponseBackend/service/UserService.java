/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.service;

import com.example.DisasterResponseBackend.model.User;
import com.example.DisasterResponseBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    
    public Optional<User> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
    
    public User saveUser(User user){
        return userRepository.save(user);
        
    }
    
}
