//package com.example.techeazy.student_management_system.controller;
//
//import com.example.techeazy.student_management_system.dto.StudentDto;
//import com.example.techeazy.student_management_system.exception.BadRequestException;
//import com.example.techeazy.student_management_system.model.Response;
//import com.example.techeazy.student_management_system.service.StudentService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/student")
//public class StudentController {
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @PostMapping("/add")
//    public ModelAndView addStudent(@RequestBody StudentDto studentDto) {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = studentService.createStudent(studentDto);
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("studentCreationResult"); // Specify the view name
//        return modelAndView;
//    }
//
//    @GetMapping("/list")
//    public ModelAndView listStudents() {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = studentService.getAllStudents();
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("studentList"); // Specify the view name
//        return modelAndView;
//    }
//
//    @PostMapping("/assign/{id}")
//    public ModelAndView assignSubjects(@PathVariable String id, @RequestBody List<String> subjects) throws BadRequestException {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = studentService.assignSubjectsToStudentById(convertIdToLong(id), subjects);
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("subjectAssignmentResult"); // Specify the view name
//        return modelAndView;
//    }
//
//    @GetMapping("/details/{id}")
//    public ModelAndView getStudentDetails(@PathVariable String id) throws BadRequestException {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = studentService.getStudentById(convertIdToLong(id));
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("studentDetails"); // Specify the view name
//        return modelAndView;
//    }
//
//    private Long convertIdToLong(String id) throws BadRequestException {
//        try {
//            return Long.parseLong(id);
//        } catch (NumberFormatException e) {
//            throw new BadRequestException("Invalid ID format: " + id);
//        }
//    }
//}
