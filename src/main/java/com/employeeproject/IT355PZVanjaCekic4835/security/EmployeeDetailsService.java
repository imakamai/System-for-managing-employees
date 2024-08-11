package com.employeeproject.IT355PZVanjaCekic4835.security;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class EmployeeDetailsService implements UserDetailsService {
    private final EmployeeService employeeService;

    public EmployeeDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeService.findByEmails(username);
        return new com.employeeproject.IT355PZVanjaCekic4835.security.EmployeeDetails(employee);
    }
}
