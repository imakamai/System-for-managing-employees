//package com.employeeproject.IT355PZVanjaCekic4835.services.impl;
//
//import com.employeeproject.IT355PZVanjaCekic4835.entity.EmployeeRole;
//import com.employeeproject.IT355PZVanjaCekic4835.repository.EmployeeRoleRepository;
//import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeeRoleService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class EmployeeRoleServiceImpl implements EmployeeRoleService {
//
//    private final EmployeeRoleRepository employeeRoleRepository;
//    @Override
//    public List<EmployeeRole> getAllEmployeeRoles() {
//        return employeeRoleRepository.findAll();
//    }
//
//    @Override
//    public EmployeeRole getEmployeeRoleById(Integer id) {
//        return employeeRoleRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public EmployeeRole saveEmployeeRole(EmployeeRole employeeRole) {
//        return employeeRoleRepository.save(employeeRole);
//    }
//
//    @Override
//    public void deleteEmployeeRole(Integer id) {
//        employeeRoleRepository.deleteById(id);
//    }
//}
