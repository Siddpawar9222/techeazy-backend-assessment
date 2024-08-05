package com.example.techeazy.student_management_system.mapper;

import com.example.techeazy.student_management_system.dto.SubjectDto;
import com.example.techeazy.student_management_system.model.Subject;

public class SubjectMapper {

    public static SubjectDto mapToSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        return subjectDto;
    }

    public static Subject mapToSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        return subject;
    }
}
