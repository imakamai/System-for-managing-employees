package com.employeeproject.IT355PZVanjaCekic4835.entity;

import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private RoleType roleType;

    @ManyToMany(mappedBy = "roles")
    private Set<Employee> employees = new HashSet<>();
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "employee_id")
////    private Employee employee;
//
//    @ManyToMany(mappedBy = "roles")
//    private Set<Employee> employees = new HashSet<>();

    public Role() {
    }

    public Role(Integer roleId, RoleType roleType, Set<Employee> employees) {
        this.roleId = roleId;
        this.roleType = roleType;
        this.employees = employees;
    }
}
