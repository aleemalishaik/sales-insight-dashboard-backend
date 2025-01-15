package com.sales.dashboard.sales_insights_backend.service;

import com.sales.dashboard.sales_insights_backend.model.User;

public interface UserService {
    User addUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
