package com.example.techeazy.student_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestRestController {


    @GetMapping("/welcome")
    public String testApplication(){
        return "Welcome to Spring Boot Application" ;
    }
}
