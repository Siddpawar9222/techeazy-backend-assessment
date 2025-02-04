package com.example.techeazy.student_management_system.repository;

import com.example.techeazy.student_management_system.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

    List<Subject> findByNameIn(List<String> names);

    boolean existsByName(String name);


    @Query("SELECT s.name FROM Subject s")
    List<String> findAllNames();
}
