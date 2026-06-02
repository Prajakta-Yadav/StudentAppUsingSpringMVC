package com.PracticeRESTAPI.PracticeRESTAPI.service.Impl;

import com.PracticeRESTAPI.PracticeRESTAPI.dto.StudentDto;
import com.PracticeRESTAPI.PracticeRESTAPI.entity.Student;
import com.PracticeRESTAPI.PracticeRESTAPI.repository.StudentRepository;
import com.PracticeRESTAPI.PracticeRESTAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDto> getAllStudent() {
        return List.of();
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }

}
