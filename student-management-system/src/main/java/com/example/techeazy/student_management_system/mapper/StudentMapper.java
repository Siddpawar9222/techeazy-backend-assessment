package com.example.techeazy.student_management_system.mapper;

import com.example.techeazy.student_management_system.dto.StudentDto;
import com.example.techeazy.student_management_system.model.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getUsername());
        studentDto.setAddress(student.getAddress());
        studentDto.setSubjects(student.getSubjects());
        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setUsername(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());
        student.setSubjects(studentDto.getSubjects());
        return student;
    }
}
