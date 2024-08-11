//package com.employeeproject.IT355PZVanjaCekic4835.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "employee_role")
//public class EmployeeRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
//    private Employee employee;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
//    private Role role;
//
//
//    public EmployeeRole() {
//    }
//
//    public EmployeeRole(Employee employee, Role role) {
//        this.employee = employee;
//        this.role = role;
//    }
//}
