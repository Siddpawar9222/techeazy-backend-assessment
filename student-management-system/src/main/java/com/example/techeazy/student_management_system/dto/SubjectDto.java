package com.example.techeazy.student_management_system.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public class SubjectDto {

    @Nullable
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;


    public SubjectDto() {
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
}
