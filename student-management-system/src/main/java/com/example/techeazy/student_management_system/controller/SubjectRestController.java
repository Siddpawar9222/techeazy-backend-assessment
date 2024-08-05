package com.example.techeazy.student_management_system.controller;

import com.example.techeazy.student_management_system.dto.SubjectDto;
import com.example.techeazy.student_management_system.model.Response;
import com.example.techeazy.student_management_system.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject/")
public class SubjectRestController {

    private  final SubjectService subjectService;

    public SubjectRestController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/createSubjects")
    public ResponseEntity<Response> createSubjects(@RequestBody List<SubjectDto> subjectDtos) {
        return new ResponseEntity<>(subjectService.createSubjects(subjectDtos), HttpStatus.CREATED);
    }


    @GetMapping("/getAllSubjects")
    public ResponseEntity<Response> getAllSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }

}
