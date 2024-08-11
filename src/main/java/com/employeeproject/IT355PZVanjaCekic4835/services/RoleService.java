package com.employeeproject.IT355PZVanjaCekic4835.services;


import com.employeeproject.IT355PZVanjaCekic4835.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRole();

    Optional<Role> getRoleById(Integer roleId);

    Role saveRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Integer roleId);
}
