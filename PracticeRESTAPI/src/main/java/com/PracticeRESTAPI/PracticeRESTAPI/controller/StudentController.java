package com.PracticeRESTAPI.PracticeRESTAPI.controller;

import com.PracticeRESTAPI.PracticeRESTAPI.dto.StudentDto;
import com.PracticeRESTAPI.PracticeRESTAPI.entity.Student;
import com.PracticeRESTAPI.PracticeRESTAPI.repository.StudentRepository;
import com.PracticeRESTAPI.PracticeRESTAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;


//    public StudentController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }




    @GetMapping("/student")
    public List<StudentDto> getStudent(){
        return  studentService.getAllStudents();

    }

//    @GetMapping("/student/{id}")
//    public StudentDto getStudentById(){
//        return new StudentDto(41, "Prajakta", "prajaktay81@gmail.com");
//
//    }

}
