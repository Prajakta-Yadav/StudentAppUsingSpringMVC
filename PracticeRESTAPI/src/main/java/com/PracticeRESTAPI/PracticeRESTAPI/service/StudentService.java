package com.PracticeRESTAPI.PracticeRESTAPI.service;

//service convert entity data into dto and dto data into Entity.

import com.PracticeRESTAPI.PracticeRESTAPI.dto.StudentDto;

import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface StudentService {


    List<StudentDto> getAllStudents();
}