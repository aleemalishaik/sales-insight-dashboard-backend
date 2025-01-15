package com.sales.dashboard.sales_insights_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Enumerated(EnumType.STRING) // Store as a String in the DB
    @Column(name = "role_name", nullable = false, unique = true)
    private RoleType roleName; // Use RoleType enum directly

    // // Custom setter for roleName to accept RoleType
    // public void setRoleName(RoleType roleName) {
    //     this.roleName = roleName;
    // }

    // // Custom getter for roleName to return RoleType
    // public RoleType getRoleName() {
    //     return roleName;
    // }
}
