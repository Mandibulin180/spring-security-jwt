package com.jwt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    public String readAdmin(){
        return "Read Admin";
    }

    @PostMapping
    public String createAdmin(){
        return "Create Admin";
    }

    @DeleteMapping
    public String deleteAdmin(){
        return "Delete Admin";
    }

    @PostMapping("/update")
    public String updateAdmin(){
        return "Update Admin";
    }
    
    
}
