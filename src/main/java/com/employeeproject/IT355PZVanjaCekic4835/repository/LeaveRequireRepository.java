package com.employeeproject.IT355PZVanjaCekic4835.repository;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.LeaveRequire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequireRepository extends JpaRepository<LeaveRequire, Integer> {
    //LeaveRequire findByLRequire_id(int id);
}
