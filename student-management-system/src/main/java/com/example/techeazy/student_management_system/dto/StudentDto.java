package com.example.techeazy.student_management_system.dto;

import com.example.techeazy.student_management_system.model.Subject;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class StudentDto {

    @Nullable
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name ;

    @NotBlank(message = "Email is mandatory")
    private String email ;


    @NotBlank(message = "Address is mandatory")
    private String address ;

    @Nullable
    private List<Subject> subjects ;


    public StudentDto() {
    }

    public StudentDto(Long id ,String name, String email, String address, @Nullable List<Subject> subjects) {
        this.id =id ;
        this.name = name;
        this.email = email;
        this.address = address;
        this.subjects = subjects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Nullable
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(@Nullable List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
