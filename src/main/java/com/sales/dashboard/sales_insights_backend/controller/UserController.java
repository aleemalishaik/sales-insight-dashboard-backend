package com.sales.dashboard.sales_insights_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sales.dashboard.sales_insights_backend.model.User;
import com.sales.dashboard.sales_insights_backend.service.UserServiceImpl;

@RestController
@RequestMapping("/api/users") // API base path
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // Test endpoint to verify the controller is working
    @GetMapping("/testuser")
    public String testEndpoint() {
        return "UserController is working!";
    }

    // Add a new user
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            User newUser = userService.addUser(user); // Add the user through the service
            return ResponseEntity.ok("User added successfully! User ID: " + newUser.getId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding user: " + e.getMessage());
        }
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            User user = userService.getUserById(id); // Retrieve the user from the service
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("User not found: " + e.getMessage());
        }
    }

    // Update a user
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user); // Update the user via the service
            return ResponseEntity.ok("User updated successfully! User ID: " + updatedUser.getId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating user: " + e.getMessage());
        }
    }

    // Delete a user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id); // Delete the user through the service
            return ResponseEntity.ok("User deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }
    }
}
