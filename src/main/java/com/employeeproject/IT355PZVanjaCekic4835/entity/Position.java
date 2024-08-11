package com.employeeproject.IT355PZVanjaCekic4835.entity;

import com.employeeproject.IT355PZVanjaCekic4835.enums.PositionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "position_info")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "positionType")
    private PositionType positionType;

    @Column(name = "mothly_working_hours")
    private Integer mothlyWorkingHours;

    @Column(name = "salary_per_hour")
    private Integer salaryPerHour;

    public Position() {
    }

    public Position(Integer positionId, PositionType positionType, Integer mothlyWorkingHours, Integer salaryPerHour) {
        this.positionId = positionId;
        this.positionType = positionType;
        this.mothlyWorkingHours = mothlyWorkingHours;
        this.salaryPerHour = salaryPerHour;
    }
}
