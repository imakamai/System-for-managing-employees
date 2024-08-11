package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.dto.EmployeeDTO;
import com.employeeproject.IT355PZVanjaCekic4835.dto.LoginDTO;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Position;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Role;
import com.employeeproject.IT355PZVanjaCekic4835.enums.PositionType;
import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
import com.employeeproject.IT355PZVanjaCekic4835.repository.EmployeeRepository;
import com.employeeproject.IT355PZVanjaCekic4835.repository.RoleRepository;
import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeeService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.catalina.Authenticator;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final RoleRepository roleRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + employeeId);
        }
    }
//    @Override
//    public Employee getEmployeeById(Integer employeeId) {
//        Optional<Employee> result = employeeRepository.findById(employeeId);
//
//        Employee emp;
//
//        if (result.isPresent()) {
//            emp = result.get();
//        }
//        else {
//            throw new RuntimeException("Did not find employee id - " + employeeId);
//        }
//
//        return emp;
////        return employeeRepository.findById(employeeId);
//    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO getEmployeeWithRoles(Integer employeeId) {
        List<Object[]> results = employeeRepository.findEmployeeWithRoles(employeeId);
        if (results.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        Set<RoleType> roles = results.stream()
                .map(row -> (RoleType) row[1])
                .collect(Collectors.toSet());

        Employee employee = (Employee) results.getFirst()[0];
        return new EmployeeDTO(employee.getEmployeeId(), employee.getName(), employee.getLastname(),
                employee.getEmail(), employee.getRegistrationNumber(), roles);
    }

//    @Override
//    public Employee getLogInEmployee(LoginDTO loginDTO) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        Employee employee;
//        BeanUtils.copyProperties(employeeService.), userLoginResponse);
//        return ResponseEntity.ok(userLoginResponse);
//    }
//    @Override
//    public EmployeeDTO getEmployeeWithRoles(Integer employeeId) {
//        EmployeeDTO employeeDTO = employeeRepository.findEmployeeDetails(employeeId);
//        if (employeeDTO == null) {
//            throw new RuntimeException("Employee not found");
//        }
//
//        Set<RoleType> roles = employeeRepository.findEmployeeRoles(employeeId);
//        employeeDTO.setRoles(roles);
//
//        return employeeDTO;
//    }
//    @Override
//    public EmployeeDTO getEmployeeWithRoles(Integer employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
//        Set<RoleType> roles = employee.getRoles().stream().map(Role::getRoleType).collect(Collectors.toSet());
//        return new EmployeeDTO(employee.getEmployeeId(), employee.getName(), employee.getLastname(), roles);
//    }


    @Override
    public Optional<Employee> getByRegistrationNumber(Integer registrationNumber) {
        return employeeRepository.findByRegistrationNumber(registrationNumber);
    }

    @Override
    public Employee findByEmails(String email) {
        return employeeRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Employee not found!"));
    }


    @Override
    public void assignRolesBasedOnPosition(Employee employee, Position position) {
        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByRoleType(RoleType.USER);
        roles.add(userRole);

        if (position.getPositionType() == PositionType.CEO || position.getPositionType() == PositionType.DIRECTOR) {
            Role adminRole = roleRepository.findByRoleType(RoleType.ADMIN);
            roles.add(adminRole);
        }

        employee.setRoles(roles);
        employeeRepository.save(employee);
    }


//    @Override
//    public String typeOfLeave(LeaveType leaveType) {
//        int leaveDays = 3;
//        int maternity = 365;
//        int vacation = 10;
//        if (leaveType == LeaveType.SICK_LEAVE){
//            return "Sick Leave" + leaveDays;
//        } else if (leaveType == LeaveType.MATERNITY) {
//            return "Maternity Leave" + maternity;
//        } else if (leaveType == LeaveType.VACATION) {
//            return "Vacation Leave" + vacation;
//
//        }else {
//            return "State Holiday" + leaveDays;
//        }
//    }
}
