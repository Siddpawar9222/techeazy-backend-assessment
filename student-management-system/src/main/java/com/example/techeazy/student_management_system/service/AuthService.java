package com.example.techeazy.student_management_system.service;


import com.example.techeazy.student_management_system.dto.UserDto;
import com.example.techeazy.student_management_system.exception.*;
import com.example.techeazy.student_management_system.mapper.UserMapper;
import com.example.techeazy.student_management_system.model.ERole;
import com.example.techeazy.student_management_system.model.Response;
import com.example.techeazy.student_management_system.model.Role;
import com.example.techeazy.student_management_system.model.User;
import com.example.techeazy.student_management_system.repository.AdminRepository;
import com.example.techeazy.student_management_system.repository.RoleRepository;
import com.example.techeazy.student_management_system.repository.StudentRepository;
import com.example.techeazy.student_management_system.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class AuthService {
    private final Logger LOG = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;

    private final RoleRepository roleRepository ;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;




    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Transactional
    public Response registerUser(UserDto userDto) throws BadRequestException, ResourceUnavailableException, UsernameAlreadyExistException {

        LOG.info("registerUser service has started ::: {} ",new Date());
        Boolean existsByUsername = userRepository.existsByUsername(userDto.getEmail());

        if (existsByUsername) {
            throw new UsernameAlreadyExistException("Username already exist, use different one");
        }


        List<String> roleList = userDto.getRoles();

        List<Role> role = new ArrayList<>();

        User user = new User();
           user.setUsername(userDto.getEmail());
           user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        if (roleList == null) {
             Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT).orElseThrow(() -> new RuntimeException("Student Role not available"));
            role.add(userRole);
        } else {
            for (String r : roleList) {
                if (r.equalsIgnoreCase("admin")) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new ResourceUnavailableException("ADMIN Role is not available "));
                    role.add(adminRole);
                } else if (r.equalsIgnoreCase("student")) {
                    Role userRole = roleRepository.findByName(ERole.ROLE_STUDENT)
                            .orElseThrow(() -> new ResourceUnavailableException("Student Role is not available"));
                    role.add(userRole);
                } else {
                    throw new BadRequestException("Only Admin Or Student role is available");
                }
            }
        }

        user.setRoles(role);
        User save = userRepository.save(user);

        UserDto savedUserDto = UserMapper.mapUserToUserDto(save);

        Response response = new Response();

        response.setMessage("Registration Successful....Please Login");
        response.setData(savedUserDto);
        response.setResultCode(201);

        LOG.info("registerUser service has ended ::: {} ",new Date());
        return response ;
    }


    public Response authenticateAndGetToken(UserDto userDto) throws LoginException {
        LOG.info("authenticateAndGetToken service has started ::: {} ",new Date());
        Response response = new Response();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
            if (authentication.isAuthenticated()) {
                Integer userId = userRepository.findIdByUsername(userDto.getEmail());
                String jwtToken = jwtService.generateToken(userDto.getEmail(), userId);

                response.setData(jwtToken);
                response.setMessage("Login Successful");
                response.setResultCode(200);
            } else {
                throw new UsernameNotFoundException("Invalid user request !");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new LoginException("Authentication failed: " + e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
            throw new CaughtException("Error while authenticating user : " + e.getMessage());
        }
        LOG.info("authenticateAndGetToken service has ended ::: {} ",new Date());
        return response ;
    }

//    @Transactional
//    public Response getAllRegisteredUsers(){
//        LOG.info("getAllRegisteredUsers service has started ::: {} ",new Date());
//        Response response = new Response();
//        try{
//            List<User> allUser = userRepository.findAll();
//            List<UserDto> responseList = new ArrayList<>();
//            for (User user : allUser) {
//                UserDto userDto = new UserDto(user.getId(), user.getUsername(),null, Arrays.asList(user.getRoles().stream().map(Role::getName).toArray(String[]::new)));
//                 responseList.add(userDto);
//            }
//
//            response.setData(responseList);
//            response.setMessage("Users fetched successfully");
//            response.setResultCode(200);
//        }catch (Exception e){
//            LOG.error("Error while fetching users : {}", e.getMessage());
//            throw new CaughtException(e.getMessage());
//        }
//        LOG.info("getAllRegisteredUsers service has ended ::: {} ",new Date());
//        return response;
//    }

}
