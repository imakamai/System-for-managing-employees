//package com.employeeproject.IT355PZVanjaCekic4835.controller;
//
//import com.employeeproject.IT355PZVanjaCekic4835.entity.Employee;
//import com.employeeproject.IT355PZVanjaCekic4835.entity.EmployeeRole;
//import com.employeeproject.IT355PZVanjaCekic4835.entity.Role;
//import com.employeeproject.IT355PZVanjaCekic4835.services.EmployeeRoleService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employee")
//@AllArgsConstructor
//public class EmployeeRoleController {
//    private final EmployeeRoleService employeeRoleService;
//
//
//@GetMapping("/employee-roles")
//public ResponseEntity<List<EmployeeRole>> getAllEmployeeRoles() {
//    return ResponseEntity.ok(employeeRoleService.getAllEmployeeRoles());
//}
//
//
//    @GetMapping("/employee-role/{id}")
//    public ResponseEntity<EmployeeRole> getEmployeeRoleById(@PathVariable Integer id) {
//        return ResponseEntity.ok(employeeRoleService.getEmployeeRoleById(id));
//    }
//    @PostMapping("/employee-role")
//    public ResponseEntity<EmployeeRole> createEmployeeRole (@RequestBody EmployeeRole employeeRole){
//        return ResponseEntity.ok(employeeRoleService.saveEmployeeRole(employeeRole));
//    }
//
//    @PutMapping("/employee-role/{id}")
//    public ResponseEntity<EmployeeRole> updateEmployeeRole (@PathVariable("id") Integer id, @RequestBody EmployeeRole employeeRole){
//        employeeRole.setId(id);
//        return ResponseEntity.ok(employeeRoleService.saveEmployeeRole(employeeRole));
//    }
//
//    @DeleteMapping("/employee-role/{id}")
//    public ResponseEntity<Void> deleteEmployeeRole(@PathVariable Integer id) {
//        employeeRoleService.getEmployeeRoleById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    //    @GetMapping("/employee-roles")
////    public List<EmployeeRole> getAllEmployeeRoles() {
////        return employeeRoleService.getAllEmployeeRoles();
////    }
//
////    @GetMapping("/employee-role/{id}")
////    public ResponseEntity<EmployeeRole> getEmployeeRoleById(@PathVariable Integer id) {
////        EmployeeRole employeeRole = employeeRoleService.getEmployeeRoleById(id);
////        if (employeeRole != null) {
////            return ResponseEntity.ok(employeeRole);
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @PostMapping("/employee-role")
////    public EmployeeRole createEmployeeRole(@RequestBody EmployeeRole employeeRole) {
////        return employeeRoleService.saveEmployeeRole(employeeRole);
////    }
////
////    @PutMapping("/employee-role/{id}")
////    public ResponseEntity<EmployeeRole> updateEmployeeRole(@PathVariable Integer id, @RequestBody EmployeeRole employeeRoleDetails) {
////        EmployeeRole employeeRole = employeeRoleService.getEmployeeRoleById(id);
////        if (employeeRole != null) {
////            employeeRole.setEmployee(employeeRoleDetails.getEmployee());
////            employeeRole.setRole(employeeRoleDetails.getRole());
////            EmployeeRole updatedEmployeeRole = employeeRoleService.saveEmployeeRole(employeeRole);
////            return ResponseEntity.ok(updatedEmployeeRole);
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
////
////    @DeleteMapping("/employee-role/{id}")
////    public ResponseEntity<Void> deleteEmployeeRole(@PathVariable Integer id) {
////        EmployeeRole employeeRole = employeeRoleService.getEmployeeRoleById(id);
////        if (employeeRole != null) {
////            employeeRoleService.deleteEmployeeRole(id);
////            return ResponseEntity.noContent().build();
////        } else {
////            return ResponseEntity.notFound().build();
////        }
////    }
//
//
//}
