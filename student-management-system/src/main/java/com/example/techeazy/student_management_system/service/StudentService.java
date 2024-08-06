package com.example.techeazy.student_management_system.service;

import com.example.techeazy.student_management_system.dto.StudentDto;
import com.example.techeazy.student_management_system.exception.CaughtException;
import com.example.techeazy.student_management_system.exception.UsernameAlreadyExistException;
import com.example.techeazy.student_management_system.mapper.StudentMapper;
import com.example.techeazy.student_management_system.model.*;
import com.example.techeazy.student_management_system.repository.RoleRepository;
import com.example.techeazy.student_management_system.repository.StudentRepository;
import com.example.techeazy.student_management_system.repository.SubjectRepository;
import com.example.techeazy.student_management_system.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

 private final Logger LOG = LoggerFactory.getLogger(StudentService.class);


    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository ;


    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }


    @Transactional
    public Response createStudent(StudentDto studentDto) {
        LOG.info("createStudent service has started ::: {} ", new Date());
        Response response = new Response();

        try{
            boolean isExists = studentRepository.existsByUsername(studentDto.getEmail());
            if(isExists){
                throw new UsernameAlreadyExistException("Email already exist, use different one");
            }

            Student student = StudentMapper.mapToStudent(studentDto);
            Student saveStudent = studentRepository.save(student);

            response.setMessage("Student created successfully");
            response.setData(saveStudent);
            response.setResultCode(201);
        }catch (Exception e){
            e.printStackTrace();
            LOG.error("Error while creating student : {}", e.getMessage());
            e.printStackTrace();
            throw new CaughtException(e.getMessage());
        }
        LOG.info("createStudent service has ended ::: {} ", new Date());
        return response;
    }

    @Transactional
    public Response getAllStudents() {
        LOG.info("getAllStudents service has started ::: {} ", new Date());
        Response response = new Response();
        try{
            response.setData(studentRepository.findAll());

            response.setMessage("Students fetched successfully");
            response.setResultCode(200);
        }catch (Exception e){
            LOG.error("Error while fetching students : {}", e.getMessage());
            e.printStackTrace();
            throw new CaughtException(e.getMessage());
        }
        LOG.info("getAllStudents service has ended ::: {} ", new Date());
        return response;
    }

    @Transactional
    public Response assignSubjectsToStudentById(Long id , List<String> subjectNames) {
        LOG.info("assignSubjectsToStudent service has started ::: {} ", new Date());
        Response response = new Response();

        try {
            Optional<Student> studentOptional = studentRepository.findById(id);
            if (!studentOptional.isPresent()) {
                response.setMessage("Student not found");
                return response;
            }
            Student student = studentOptional.get();

            // Check if all subjects exist
            List<String> allSubjectNames = subjectRepository.findAll().stream().map(Subject::getName).toList();

            List<Subject> subjects = subjectRepository.findByNameIn(subjectNames);
            if (subjects.size() != subjectNames.size()) {
                response.setMessage("One or more subjects not found. Available subjects: " + allSubjectNames);
                return response;
            }

            // Assign subjects to the student
            student.setSubjects(subjects);
            studentRepository.save(student);

            response.setMessage("Subjects assigned successfully");
            response.setResultCode(200);
            response.setData(student);

        } catch (Exception e) {
            LOG.error("Error while assigning subjects to student : {}", e.getMessage());
            e.printStackTrace();
            throw new CaughtException(e.getMessage());
        }
        LOG.info("assignSubjectsToStudent service has ended ::: {} ", new Date());
        return response;
    }

   public Response getStudentById(Long id){
       LOG.info("getStudentById service has started ::: {} ", new Date());
       Response response = new Response();
       try{
           Optional<Student> studentOptional = studentRepository.findById(id);
           if (!studentOptional.isPresent()) {
               response.setMessage("Student not found");
               return response;
           }
           Student student = studentOptional.get();
           response.setData(student);
           response.setMessage("Student fetched successfully");
           response.setResultCode(200);
       }catch (Exception e){
           LOG.error("Error while fetching student : {}", e.getMessage());
           e.printStackTrace();
           throw new CaughtException(e.getMessage());
       }
       LOG.info("getStudentById service has ended ::: {} ", new Date());
       return response;
   }


}
