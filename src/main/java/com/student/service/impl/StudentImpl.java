package com.student.service.impl;

import com.student.entity.Student;
import com.student.payload.StudentDTO;
import com.student.payload.StudentResponse;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO createDetails(StudentDTO studentDTO) {
        Student saveDetails = studentRepository.save(mapToEntity(studentDTO));
        return mapToDTO(saveDetails);
    }

    @Override
    public StudentResponse getAllStudent(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Student> all = studentRepository.findAll(pageable);
        // get content for page object
        List<Student> listOfStudent = all.getContent();
        List<StudentDTO> content= listOfStudent.stream().map(student ->
                mapToDTO(student)).collect(Collectors.toList());
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setContent(content);
        studentResponse.setPageNo(all.getNumber());
        studentResponse.setPageSize(all.getSize());
        studentResponse.setTotalNoElement(all.getTotalElements());
        studentResponse.setTotalPage(all.getTotalPages());
        studentResponse.setLast(all.isLast());
        return studentResponse;
    }

    public Student mapToEntity(StudentDTO studentDTO){
        Student student = modelMapper.map(studentDTO, Student.class);
        return student;
    }
    public StudentDTO mapToDTO(Student student){
        StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
        return studentDTO;
    }
}
