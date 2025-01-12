package com.sales.dashboard.sales_insights_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sales.dashboard.sales_insights_backend.model.User;
import com.sales.dashboard.sales_insights_backend.service.UserService;

@RestController
@RequestMapping("/api/users") // API base path
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/testuser")
    public String testEndpoint() {
        return "user is working!";
    }
    @PostMapping("/add")
public ResponseEntity<String> addUser(@RequestBody User user) {
    try {
        User newUser = userService.addUser(user.getEmail().toString(), user.getPassword().toString(), user.getRole());
        return ResponseEntity.ok("User added successfully! User ID: " + newUser.getId());
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Error adding user: " + e.getMessage());
    }
}
}