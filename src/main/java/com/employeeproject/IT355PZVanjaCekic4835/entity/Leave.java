package com.employeeproject.IT355PZVanjaCekic4835.entity;

import com.employeeproject.IT355PZVanjaCekic4835.enums.LeaveType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "leave_table")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private Integer leaveId;

    @Column(name = "leaveType")
    private LeaveType leaveType;


    public Leave() {
    }

    public Leave(Integer leaveId, LeaveType leaveType) {
        this.leaveId = leaveId;
        this.leaveType = leaveType;
    }


}
