/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.DisasterResponseBackend.model;

import jakarta.persistence.*;
@Entity 
@Table(name= "users")



/**
 *
 * @author USER
 */
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String role;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    //Default constructor
    public User(){}
    
    //Constructor with parameters 
    public User(String username, String password, String role,String email){
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }
    
    //Getters and setters
    public Long getId(){return id;}   
    public void setId(Long id){this.id = id;}
    
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    
    public String getRole(){return role;}
    public void setRole(String role){this.role = role;}
    
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    
}
