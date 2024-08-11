package com.employeeproject.IT355PZVanjaCekic4835.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employee_leave")
public class LeaveRequire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_leave_id", nullable = false)
    private Integer employeeLeaveId;

    @Column(name = "leave_request")
    private String leaveRequest;

    @Column(name = "leave_request_date")
    private Date leaveRequestDate;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_id", referencedColumnName = "leave_id")
    private Leave leave;

    public LeaveRequire() {
    }

    public LeaveRequire(Integer employeeLeaveId, String leaveRequest, Date leaveRequestDate, Boolean isApproved, Employee employee, Leave leave) {
        this.employeeLeaveId = employeeLeaveId;
        this.leaveRequest = leaveRequest;
        this.leaveRequestDate = leaveRequestDate;
        this.isApproved = isApproved;
        this.employee = employee;
        this.leave = leave;
    }
}
