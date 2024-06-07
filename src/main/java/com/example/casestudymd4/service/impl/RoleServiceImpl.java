package com.example.casestudymd4.service.impl;

import com.example.casestudymd4.model.Role;
import com.example.casestudymd4.repository.RoleRepository;
import com.example.casestudymd4.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findRoleById(id);
    }
}
