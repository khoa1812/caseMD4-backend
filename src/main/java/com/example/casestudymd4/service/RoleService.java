package com.example.casestudymd4.service;

import com.example.casestudymd4.model.Role;

import java.util.Optional;

public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
    Role findById(Long id);
}
