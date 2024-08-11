package com.employeeproject.IT355PZVanjaCekic4835.services;


import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.LeaveRequire;

import java.util.List;
import java.util.Optional;

public interface LeaveRequireService {
    List<LeaveRequire> getAllLeaveRequire();

    Optional<LeaveRequire> getLeaveRequireById(Integer leaveRequireId);

    LeaveRequire approveLeaveRequest(Integer id);

    LeaveRequire saveLeaveRequest(LeaveRequire leaveRequire);

    List<LeaveRequire> getLeaveRequestsByEmployee(Employee employee);
}
