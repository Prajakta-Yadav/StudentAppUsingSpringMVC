package com.RESTAPIPractice.RESTAPIPractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // it automatically create get set method, constructor
@AllArgsConstructor//create constructor for all argument.
public class StudentDto {

    private long id;
    private String name;
    private String email;


//    public StudentDto(int id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//
//    }
}


