package com.example.techeazy.student_management_system.controller;

import com.example.techeazy.student_management_system.dto.UserDto;
import com.example.techeazy.student_management_system.exception.BadRequestException;
import com.example.techeazy.student_management_system.exception.LoginException;
import com.example.techeazy.student_management_system.exception.ResourceUnavailableException;
import com.example.techeazy.student_management_system.exception.UsernameAlreadyExistException;
import com.example.techeazy.student_management_system.model.Response;
import com.example.techeazy.student_management_system.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    private final AuthService authService ;

    public AuthRestController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody @Valid UserDto userDto) throws BadRequestException, ResourceUnavailableException, UsernameAlreadyExistException {
        return ResponseEntity.ok(authService.registerUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> authenticateUser(@RequestBody @Valid UserDto userDto) throws LoginException {
           return  ResponseEntity.ok(authService.authenticateAndGetToken(userDto));
    }

//    @GetMapping("/allRegisteredUser")
//    public ResponseEntity<Response> getAllRegister() {
//        return ResponseEntity.ok(authService.getAllRegisteredUsers());
//    }
}
