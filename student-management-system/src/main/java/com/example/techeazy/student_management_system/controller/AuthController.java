//package com.example.techeazy.student_management_system.controller;
//
//
//import com.example.techeazy.student_management_system.dto.UserDto;
//import com.example.techeazy.student_management_system.exception.BadRequestException;
//import com.example.techeazy.student_management_system.exception.LoginException;
//import com.example.techeazy.student_management_system.exception.ResourceUnavailableException;
//import com.example.techeazy.student_management_system.exception.UsernameAlreadyExistException;
//import com.example.techeazy.student_management_system.model.Response;
//import com.example.techeazy.student_management_system.service.AuthService;
//import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public ModelAndView registerUser(@RequestBody @Valid UserDto userDto) throws ResourceUnavailableException, BadRequestException, UsernameAlreadyExistException {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = authService.registerUser(userDto);
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("registerResult"); // Specify the view name
//        return modelAndView;
//    }
//
//    @PostMapping("/login")
//    public ModelAndView authenticateUser(@RequestBody @Valid UserDto userDto) throws LoginException {
//        ModelAndView modelAndView = new ModelAndView();
//        Response response = authService.authenticateAndGetToken(userDto);
//        modelAndView.addObject("response", response);
//        modelAndView.setViewName("loginResult"); // Specify the view name
//        return modelAndView;
//    }
//
////    @GetMapping("/all")
////    public ModelAndView getAllRegisteredUsers() {
////        ModelAndView modelAndView = new ModelAndView();
////        try {
////            Response response = authService.getAllRegisteredUsers();
////            modelAndView.addObject("response", response);
////            modelAndView.setViewName("userList"); // Specify the view name
////        } catch (Exception e) {
////            modelAndView.addObject("error", e.getMessage());
////            modelAndView.setViewName("error"); // Generic error view name
////        }
////        return modelAndView;
////    }
//}
