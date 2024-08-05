package com.example.techeazy.student_management_system.repository;


import com.example.techeazy.student_management_system.model.ERole;
import com.example.techeazy.student_management_system.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
