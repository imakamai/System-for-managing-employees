package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.entity.EmployeePosition;
import com.employeeproject.IT355PZVanjaCekic4835.repository.EmployeePositionRepository;
import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeePositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeePositionServiceImpl implements EmployeePositionService {

    private final EmployeePositionRepository employeePositionRepository;


    @Override
    public List<EmployeePosition> getAllEmployeePositions() {
        return employeePositionRepository.findAll();
    }

    @Override
    public Optional<EmployeePosition> getEmployeePositionById(Integer employeePositionId) {
        return employeePositionRepository.findById(employeePositionId);
    }


}
