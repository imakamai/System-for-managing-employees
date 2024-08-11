
package com.employeeproject.IT355PZVanjaCekic4835.controller;


import com.employeeproject.IT355PZVanjaCekic4835.dto.LoginDTO;
import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.enums.RoleType;
import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/login-page")
    public ResponseEntity<Employee> getLogInEmployee(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return ResponseEntity.ok(employeeService.findByEmails(loginDTO.getEmail()));
    }

    @GetMapping("/employeess")
    public ResponseEntity<List<Employee>> getAllEmployees(Principal principal) {
        String email = principal.getName();
        Employee employee = employeeService.findByEmails(email);
        if (isAdmin(employee)) {
            List<Employee> employees = employeeService.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(List.of(employee), HttpStatus.OK);
        }
    }

    private boolean isAdmin(Employee employee) {
        return employee.getRoles().stream()
                .anyMatch(role -> role.getRoleType() == RoleType.ADMIN);
    }

//    @GetMapping("/employees")
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        return ResponseEntity.ok(employeeService.getAllEmployees());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id) {
        employee.setEmployeeId(id);
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
//    @GetMapping("/employees")
//    public ResponseEntity<List<Employee>> getAllEmployees(Principal principal) {
//        String email = principal.getName();
//        Employee employee = employeeService.findByEmails(email)
//                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
//
//        if (isAdmin(employee)) {
//            List<Employee> employees = employeeService.getAllEmployees();
//            return new ResponseEntity<>(employees, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(List.of(employee), HttpStatus.OK);
//        }
//    }
//
//    private boolean isAdmin(Employee employee) {
//        return employee.getRoles().stream()
//                .anyMatch(role -> role.getRoleType() == RoleType.ADMIN);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(employeeService.getEmployeeById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
//        return ResponseEntity.ok(employeeService.saveEmployee(employee));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id) {
//        employee.setEmployeeId(id);
//        return ResponseEntity.ok(employeeService.updateEmployee(employee));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }