package com.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNo;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone_number", nullable = false)
    private Long phoneNum;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "total_mark", nullable = false)
    private Double totalMarks;
}
