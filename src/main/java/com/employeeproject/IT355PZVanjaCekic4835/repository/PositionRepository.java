package com.employeeproject.IT355PZVanjaCekic4835.repository;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByPositionId(int id);
}
