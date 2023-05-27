package com.student.service;

import com.student.payload.StudentDTO;
import com.student.payload.StudentResponse;

public interface StudentService {
    StudentDTO createDetails(StudentDTO studentDTO);

    StudentResponse getAllStudent(int pageNo, int pageSize, String sortBy, String sortDir);
}
