package com.example.techeazy.student_management_system.service;

import com.example.techeazy.student_management_system.dto.SubjectDto;
import com.example.techeazy.student_management_system.exception.CaughtException;
import com.example.techeazy.student_management_system.mapper.SubjectMapper;
import com.example.techeazy.student_management_system.model.Response;
import com.example.techeazy.student_management_system.model.Subject;
import com.example.techeazy.student_management_system.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SubjectService {

    private final Logger LOG = LoggerFactory.getLogger(SubjectService.class);
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }



//    @Transactional
//    public Response createSubjects(List<String> subjectNames) {
//        LOG.info("createSubjects service has started ::: {}", new Date());
//        Response response = new Response();
//
//        try {
//            List<Subject> subjects = new ArrayList<>();
//
//            for (String subjectName : subjectNames) {
//                // Check if the subject already exists
//                if (!subjectRepository.existsByName(subjectName)) {
//                    Subject subject = new Subject();
//                    subject.setName(subjectName);
//                    subjects.add(subject);
//                } else {
//                    LOG.info("Subject already exists: {}", subjectName);
//                }
//            }
//
//            // Save all new subjects
//            if (!subjects.isEmpty()) {
//                List<Subject> savedSubjects = subjectRepository.saveAll(subjects);
//                LOG.info("Subjects saved: {}", savedSubjects);
//            } else {
//                LOG.info("No new subjects to save.");
//            }
//
//            response.setData(subjectNames);
//            response.setMessage("Subjects processed successfully");
//            response.setResultCode(201);
//        } catch (Exception e) {
//            LOG.error("Error while creating subjects: {}", e.getMessage());
//            throw new CaughtException(e.getMessage());
//        }
//        LOG.info("createSubjects service has ended ::: {}", new Date());
//        return response;
//    }




    @Transactional
    public Response createSubjects(List<SubjectDto> subjectDtos){
        LOG.info("createSubjects service has started ::: {} " , new Date());
        Response response = new Response();

        try {
            Set<String> setOfNames = new HashSet<>(subjectRepository.findAllNames());

            List<Subject> subjects = new ArrayList<>();

            for(SubjectDto subjectDto : subjectDtos){
                if(!setOfNames.contains(subjectDto.getName())){
                    Subject subject = SubjectMapper.mapToSubject(subjectDto);
                    subjects.add(subject);
                }else{
                    LOG.info("Subject already exists : {}", subjectDto.getName());
                }
            }

            List<Subject> savedSubjects = subjectRepository.saveAll(subjects);
            LOG.info("Subjects saved : {}", savedSubjects);

            response.setData(savedSubjects);
            response.setMessage("Subjects created successfully");
            response.setResultCode(201);
        }catch (Exception e){
            e.printStackTrace();
            LOG.error("Error while creating subjects : {}", e.getMessage());
            throw new CaughtException(e.getMessage());
        }
        LOG.info("createSubjects service has ended ::: {} " , new Date());
        return response;
    }

    @Transactional
    public Response getAllSubjects(){
        LOG.info("getAllSubjects service has started ::: {} " , new Date());
        Response response = new Response();
        try{
            List<Subject> subjects = subjectRepository.findAll();
            List<SubjectDto> subjectDtos = new ArrayList<>();

            for(Subject subject : subjects){
                SubjectDto subjectDto = SubjectMapper.mapToSubjectDto(subject);
                subjectDtos.add(subjectDto);
            }
            response.setData(subjectDtos);
            response.setMessage("Subjects fetched successfully");
            response.setResultCode(200);
        }catch (Exception e){
            e.printStackTrace();
            LOG.error("Error while fetching subjects : {}", e.getMessage());
            throw new CaughtException(e.getMessage());
        }
        LOG.info("getAllSubjects service has ended ::: {} " , new Date());
        return response;
    }
}
