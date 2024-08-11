package com.employeeproject.IT355PZVanjaCekic4835.controller;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Role;
import com.employeeproject.IT355PZVanjaCekic4835.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRole());
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Optional<Role>> getRoleById(@PathVariable Integer id) {

        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PostMapping("/role")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.saveRole(role));
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Optional<Role>> updateRole(@PathVariable Integer id,@RequestBody Role role) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Integer id) {
        roleService.getRoleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @GetMapping("/roles")
//    public ResponseEntity<List<Role>> getAllRoles() {
//        List<Role> roles = roleService.getAllRole();
//        return new ResponseEntity<>(roles, HttpStatus.OK);
//    }
//
//    @GetMapping("/role/{id}")
//    public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id) {
//        Role role = roleService.getRoleById(id).orElseThrow(() -> new IllegalArgumentException("Role not found"));
//        return new ResponseEntity<>(role, HttpStatus.OK);
//    }
//
//    @PostMapping("/role")
//    public ResponseEntity<Role> createRole(@RequestBody Role role) {
//        Role savedRole = roleService.saveRole(role);
//        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/role/{id}")
//    public ResponseEntity<Role> updateRole(@PathVariable("id") Integer id, @RequestBody Role role) {
//        role.setRoleId(id);
//        Role updatedRole = roleService.updateRole(role);
//        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/role/{id}")
//    public ResponseEntity<?> deleteRole(@PathVariable("id") Integer id) {
//        roleService.deleteRole(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
