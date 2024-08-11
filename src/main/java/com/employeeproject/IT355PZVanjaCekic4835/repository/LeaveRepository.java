package com.employeeproject.IT355PZVanjaCekic4835.repository;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    Leave findByLeaveId(int id);
}
