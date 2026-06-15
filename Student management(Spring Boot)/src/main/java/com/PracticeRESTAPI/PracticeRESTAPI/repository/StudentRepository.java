package com.PracticeRESTAPI.PracticeRESTAPI.repository;

import com.PracticeRESTAPI.PracticeRESTAPI.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository  extends JpaRepository<Student, Long> {


    //Controller directly connect with entity but we add between one interface layer its called repository
    //this interface is a layer between controller and entity which also help to write database Queries.
    //Here we write all data access query


}
