//package com.example.techeazy.student_management_system.controller;
//
//
//import com.example.techeazy.student_management_system.dto.SubjectDto;
//import com.example.techeazy.student_management_system.model.Response;
//import com.example.techeazy.student_management_system.service.SubjectService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/subject")
//public class SubjectController {
//
//    private final SubjectService subjectService;
//
//    public SubjectController(SubjectService subjectService) {
//        this.subjectService = subjectService;
//    }
//
//    @PostMapping("/add")
//    public ModelAndView addSubjects(@RequestBody List<SubjectDto> subjectDtos) {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = subjectService.createSubjects(subjectDtos);
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("subjectCreationResult"); // Specify the view name
//        return modelAndView;
//    }
//
//    @GetMapping("/list")
//    public ModelAndView listSubjects() {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = subjectService.getAllSubjects();
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("subjectList"); // Specify the view name
//        return modelAndView;
//    }
//}
