package com.example.casestudymd4;

import com.example.casestudymd4.model.Role;
import com.example.casestudymd4.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CasestudyMd4Application {
    @Autowired
    private RoleRepository roleRepository;
    public static void main(String[] args) {
        SpringApplication.run(CasestudyMd4Application.class, args);
    }


    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            Role admin = new Role("ROLE_ADMIN");
            Role user = new Role("ROLE_USER");
            roleRepository.save(admin);
            roleRepository.save(user);
        }
    }

}
