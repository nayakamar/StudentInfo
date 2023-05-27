package com.student.payload;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponse {
    private List<StudentDTO> content;
    private int pageNo;
    private int pageSize;
    private long totalNoElement;
    private int totalPage;
    private boolean last;
}
