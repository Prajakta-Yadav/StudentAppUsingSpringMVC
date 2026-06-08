package com.PracticeRESTAPI.PracticeRESTAPI.service.Impl;

import com.PracticeRESTAPI.PracticeRESTAPI.dto.AddStudentRequestDto;
import com.PracticeRESTAPI.PracticeRESTAPI.dto.StudentDto;
import com.PracticeRESTAPI.PracticeRESTAPI.entity.Student;
import com.PracticeRESTAPI.PracticeRESTAPI.repository.StudentRepository;
import com.PracticeRESTAPI.PracticeRESTAPI.service.StudentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;


//    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
//        this.studentRepository = studentRepository;
//        this.modelMapper = modelMapper;
//    }


//    public List<StudentDto> getAllStudent() {
//        return List.of();
//    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    // orElseThrow() : above method is part of optional class.

    @Override
    public StudentDto getStudentById(long id) {

        //convert  student to StudentDTO using new object is complex. we use modelmapper library.
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student ot found ith ID: " + id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {

        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);   //this line add data into database
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " +id));
        modelMapper.map(addStudentRequestDto, student);

        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " +id));

        updates.forEach((field, value) ->{
            switch (field){
                case "name": student.setName((String) value);
                break;
                case "email":
                    student.setEmail((String) value);
                break;

                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });

        Student  saveStudent = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);

    }

}
