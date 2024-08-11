package com.employeeproject.IT355PZVanjaCekic4835.repository;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Role;
import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleId(int id);
    Role findByRoleType(RoleType roleType);
}
