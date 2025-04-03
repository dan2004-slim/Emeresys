package com.example.DisasterResponseBackend.conrollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController{
    @GetMapping
    public String testAPI(){
        return "SpringBoot Is running";
    }
}
