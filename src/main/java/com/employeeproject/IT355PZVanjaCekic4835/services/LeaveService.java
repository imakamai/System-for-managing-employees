package com.employeeproject.IT355PZVanjaCekic4835.services;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Leave;

import java.util.List;
import java.util.Optional;

public interface LeaveService {
    List<Leave> getAllLeaves();

    Optional<Leave> getLeaveById(Integer leaveId);

    Leave saveLeave(Leave leave);

    Leave updateLeave(Leave leave);

    void deleteLeave(Integer leaveId);
}
