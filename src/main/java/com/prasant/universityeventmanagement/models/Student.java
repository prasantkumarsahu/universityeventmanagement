package com.prasant.universityeventmanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String firstName;

    private String lastName;

    @Min(value = 18)
    @Max(value = 25)
    private Integer age;

    @Enumerated(value = EnumType.STRING)
    private Departments department;
}
