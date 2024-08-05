package com.example.techeazy.student_management_system.controller;

import com.example.techeazy.student_management_system.dto.StudentDto;
import com.example.techeazy.student_management_system.exception.BadRequestException;
import com.example.techeazy.student_management_system.model.Response;
import com.example.techeazy.student_management_system.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject/")
public class StudentRestController {
    private final StudentService studentService;

    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/createStudent")
    public ResponseEntity<Response> createSubjects(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }


    @GetMapping("/getAllStudents")
    public ResponseEntity<Response> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/assignSubjectsToStudentById/{id}")
    public ResponseEntity<Response> assignSubjectsToStudentById(@PathVariable String id, @RequestBody List<String> subjects) throws BadRequestException {
        return new ResponseEntity<>(studentService.assignSubjectsToStudentById(stringToLong(id), subjects), HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Response> getStudentById(@PathVariable String id) throws BadRequestException {
        return new ResponseEntity<>(studentService.getStudentById(stringToLong(id)), HttpStatus.OK);
    }


    private Long stringToLong(String id) throws BadRequestException {
        try {
            return Long.parseLong(id);
        }catch (Exception e){
             throw  new BadRequestException(e.getMessage());
        }

    }


}
