package com.sales.dashboard.sales_insights_backend.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> user) {
        return "Register endpoint under construction.";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        return "Login endpoint under construction.";
    }
}
