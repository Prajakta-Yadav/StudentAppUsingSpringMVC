package com.PracticeRESTAPI.PracticeRESTAPI.service;

//service convert entity data into dto and dto data into Entity.

import com.PracticeRESTAPI.PracticeRESTAPI.dto.AddStudentRequestDto;
import com.PracticeRESTAPI.PracticeRESTAPI.dto.StudentDto;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public interface StudentService {


    List<StudentDto> getAllStudents();

    StudentDto getStudentById(long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}