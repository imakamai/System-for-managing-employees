package com.employeeproject.IT355PZVanjaCekic4835.services;

import com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO;
import com.employeeproject.IT355PZVanjaCekic4835.dto.LoginDTO;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeService  {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer employeeId);

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeWithRoles(Integer employeeId);


    Optional<Employee> getByRegistrationNumber(Integer registrationNumber);

//    Employee findByName(String name);
//
//    Employee fidByLastName(String lastName);

    Employee findByEmails(String email);

//    void save(WebUser webUser);

    void assignRolesBasedOnPosition(Employee employee, Position position);
//    public String typeOfLeave(LeaveType leaveType);
}
