package com.employeeproject.IT355PZVanjaCekic4835.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_position")
public class EmployeePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_position_id", nullable = false)
    private Integer employeePositionId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

//    @ManyToOne
//    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    public EmployeePosition() {
    }

    public EmployeePosition(Integer employeePositionId, Employee employee, Position position) {
        this.employeePositionId = employeePositionId;
        this.employee = employee;
        this.position = position;
    }
}
