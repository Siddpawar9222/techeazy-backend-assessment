package com.example.techeazy.student_management_system.repository;

import com.example.techeazy.student_management_system.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Boolean existsByUsername(String username);
}
