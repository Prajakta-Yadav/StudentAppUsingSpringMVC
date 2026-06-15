package com.PracticeRESTAPI.PracticeRESTAPI.controller;

import com.PracticeRESTAPI.PracticeRESTAPI.dto.AddStudentRequestDto;
import com.PracticeRESTAPI.PracticeRESTAPI.dto.StudentDto;
import com.PracticeRESTAPI.PracticeRESTAPI.entity.Student;
import com.PracticeRESTAPI.PracticeRESTAPI.repository.StudentRepository;
import com.PracticeRESTAPI.PracticeRESTAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("/student")
@RequiredArgsConstructor
@RequestMapping
public class StudentController {

    private final StudentService studentService;



//    public StudentController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }



    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
       // return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());  //short-hand

    }

    @GetMapping("/{id}")
    public ResponseEntity <StudentDto> getStudentById(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/postData")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                                                    @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/{id}")

    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id,
                                                           @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }
}
