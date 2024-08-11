package com.employeeproject.IT355PZVanjaCekic4835.repository;

import com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByRegistrationNumber(Integer registrationNumber);

    @Query("SELECT e, r.roleType " +
            "FROM Employee e JOIN e.roles r WHERE e.employeeId = :employeeId")
    List<Object[]> findEmployeeWithRoles(@Param("employeeId") Integer employeeId);
//    @Query("SELECT new com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO(e.employeeId, e.name, e.lastname, e.email, e.registrationNumber) " +
//            "FROM Employee e WHERE e.employeeId = :employeeId")
//    EmployeeDTO findEmployeeDetails(@Param("employeeId") Integer employeeId);
//
//    @Query("SELECT r.roleType FROM Employee e JOIN e.roles r WHERE e.employeeId = :employeeId")
//    Set<RoleType> findEmployeeRoles(@Param("employeeId") Integer employeeId);
//    @Query("SELECT new com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO(e.employeeId, e.name, e.lastname, e.email, e.registrationNumber, r.roleType) " +
//            "FROM Employee e JOIN e.roles r WHERE e.employeeId = :employeeId")
//    EmployeeDTO findEmployeeWithRoles(@Param("employeeId") Integer employeeId);
//    @Query("SELECT new com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO(e.employeeId, e.name, e.lastname, e.email, e.registrationNumber, " +
//            "GROUP_CONCAT(r.roleType)) " +
//            "FROM Employee e JOIN e.roles r WHERE e.employeeId = :employeeId GROUP BY e.employeeId")
//    EmployeeDTO findEmployeeWithRoles(@Param("employeeId") Integer employeeId);


//    @Query("SELECT new com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO(e.employeeId, e.name, e.lastname, " +
//            "GROUP_CONCAT(r.roleType)) " +
//            "FROM Employee e JOIN e.roles r WHERE e.employeeId = :employeeId GROUP BY e.employeeId")
//    EmployeeDTO findEmployeeWithRoles(@Param("employeeId") Integer employeeId);
}
