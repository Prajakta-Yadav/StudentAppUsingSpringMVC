package com.RESTAPIPractice.RESTAPIPractice.controller;

import com.RESTAPIPractice.RESTAPIPractice.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(41, "Prajakta", "prajaktay81@gmail.com");
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(49, "Praju", "prajuy81@gmail.com");
    }


}
