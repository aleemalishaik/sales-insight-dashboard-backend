package com.sales.dashboard.sales_insights_backend.service;

import com.sales.dashboard.sales_insights_backend.model.Role;
import com.sales.dashboard.sales_insights_backend.model.RoleType;
import com.sales.dashboard.sales_insights_backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findRoleByType(RoleType roleType) {
        return roleRepository.findByRoleName(roleType.name());
    }

    public Role createRoleIfNotExists(RoleType roleType) {
        Role role = roleRepository.findByRoleName(roleType.name());
        if (role == null) {
            role = new Role();
            role.setRoleName(roleType);
            role = roleRepository.save(role);
        }
        return role;
    }
}
