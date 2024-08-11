package com.employeeproject.IT355PZVanjaCekic4835.repository;



import com.employeeproject.IT355PZVanjaCekic4835.entity.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Integer> {
    EmployeePosition findByEmployeePositionId(int id);
}
