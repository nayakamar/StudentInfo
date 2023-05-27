package com.student.payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private long id;

    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Invalid name format")
    private String name;

    @NotEmpty(message = "Roll number is required")
    private String rollNo;
    @NotEmpty(message = "Gender is required")
    private String gender;



    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @NotNull(message = "Phone number is required")
    @Digits(integer = 10, fraction = 0, message = "Invalid phone number")
    private long phoneNum;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String emailId;


    @NotNull(message = "Total marks is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total marks must be greater than 0")
    private double totalMarks;

}

