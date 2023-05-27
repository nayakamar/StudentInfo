package com.student.controller;

import com.student.payload.StudentDTO;
import com.student.payload.StudentResponse;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final StudentService studentService;
    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    //http://localhost:8080/api/students
    @PostMapping
    public ResponseEntity<?> ceateStudentDetails(@Valid @RequestBody StudentDTO studentDTO){
        StudentDTO studentDetails = studentService.createDetails(studentDTO);
        return new ResponseEntity<>(studentDetails, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/students/?pageNo=1&pageSize=3&sortBy=rollNo&sortDir=asc
    @GetMapping
    public StudentResponse getAllStudentData(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int
                    pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int
                    pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String
                    sortDir
    ){
        return studentService.getAllStudent(pageNo, pageSize, sortBy, sortDir);
    }

}