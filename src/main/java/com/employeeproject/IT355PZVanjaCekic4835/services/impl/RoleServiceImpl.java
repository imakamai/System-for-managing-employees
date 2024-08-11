package com.employeeproject.IT355PZVanjaCekic4835.services.impl;

import com.employeeproject.IT355PZVanjaCekic4835.entity.Role;
import com.employeeproject.IT355PZVanjaCekic4835.repository.RoleRepository;
import com.employeeproject.IT355PZVanjaCekic4835.services.RoleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Integer roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(Integer roleId) {
        roleRepository.deleteById(roleId);
    }
}
