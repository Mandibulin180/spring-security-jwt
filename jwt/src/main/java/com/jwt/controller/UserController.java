package com.jwt.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping
    public String readUser(){
        return "Read User";
    }

    @PostMapping
    public String createUser(){
        return "Create User";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete User";
    }

    @PostMapping("/update")
    public String updateUser(){
        return "Update User";
    }
    
}
