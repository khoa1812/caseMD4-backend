package com.example.casestudymd4.repository;

import com.example.casestudymd4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
    Role findRoleById(Long roleId);

}
