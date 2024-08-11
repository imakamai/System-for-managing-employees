package com.employeeproject.IT355PZVanjaCekic4835.services;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.EmployeePosition;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import com.employeeproject.IT355PZVanjaCekic4835.enums.PositionType;

import java.util.List;
import java.util.Optional;

public interface EmployeePositionService {
    List<EmployeePosition> getAllEmployeePositions();

    Optional<EmployeePosition> getEmployeePositionById(Integer employeePositionId);

}
