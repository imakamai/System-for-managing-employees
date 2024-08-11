package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.LeaveRequire;
import com.employeeproject.IT355PZVanjaCekic4835.repository.LeaveRequireRepository;
import com.employeeproject.IT355PZVanjaCekic4835.services.LeaveRequireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaveRequireServiceImpl implements LeaveRequireService {

    private final LeaveRequireRepository leaveRequireRepository;

    @Override
    public List<LeaveRequire> getAllLeaveRequire() {
        return leaveRequireRepository.findAll();
    }

    @Override
    public Optional<LeaveRequire> getLeaveRequireById(Integer leaveRequireId) {
        return leaveRequireRepository.findById(leaveRequireId);
    }

    @Override
    public LeaveRequire approveLeaveRequest(Integer id) {
        LeaveRequire leaveRequest = leaveRequireRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Leave request not found"));
        leaveRequest.setIsApproved(true);
        return leaveRequireRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequire saveLeaveRequest(LeaveRequire leaveRequire) {
        return leaveRequireRepository.save(leaveRequire);
    }

    @Override
    public List<LeaveRequire> getLeaveRequestsByEmployee(Employee employee) {
        return leaveRequireRepository.findAll().stream()
                .filter(request -> request.getEmployee().getEmployeeId().equals(employee.getEmployeeId()))
                .collect(Collectors.toList());
    }
    }

