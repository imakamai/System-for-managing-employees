package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Leave;
import com.employeeproject.IT355PZVanjaCekic4835.repository.LeaveRepository;
import com.employeeproject.IT355PZVanjaCekic4835.services.LeaveService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public Optional<Leave> getLeaveById(Integer leaveId) {
        return leaveRepository.findById(leaveId);
    }

    @Override
    public Leave saveLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    public Leave updateLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    @Override
    @Transactional
    public void deleteLeave(Integer leaveId) {
        leaveRepository.deleteById(leaveId);
    }
}
