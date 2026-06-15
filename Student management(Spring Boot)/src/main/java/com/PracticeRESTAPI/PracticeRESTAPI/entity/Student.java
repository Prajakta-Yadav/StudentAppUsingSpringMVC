package com.PracticeRESTAPI.PracticeRESTAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
public class Student {

    //object Relation Mapping (ORM)  Use hibernate bind it and Spring data JPA create it automatically. with @Entity annotation.
    //Student entity relationship with database.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    public long getId() {
        return this.id;
    }
}
