package com.sales.dashboard.sales_insights_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.dashboard.sales_insights_backend.model.Role;
import com.sales.dashboard.sales_insights_backend.model.User;
import com.sales.dashboard.sales_insights_backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(String email, String password, Role role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        return userRepository.save(user); // Save user to the database
    }
}