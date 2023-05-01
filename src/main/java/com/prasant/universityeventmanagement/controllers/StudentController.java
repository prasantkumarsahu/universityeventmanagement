package com.prasant.universityeventmanagement.controllers;

import com.prasant.universityeventmanagement.models.Departments;
import com.prasant.universityeventmanagement.models.Student;
import com.prasant.universityeventmanagement.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/")
    public String addStudent(@Valid @RequestBody Student student){
        return studentService.addStudentToDb(student);
    }
    @PutMapping(value = "/department/{department}/id/{id}")
    public String updateDepartmentById(@PathVariable String department, @PathVariable Integer id){
        return studentService.updateDepartmentById(Departments.valueOf(department), id);
    }
    @DeleteMapping(value = "/id/{id}")
    public String deleteStudentById(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
    }
    @GetMapping(value = "/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping(value = "/id/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
}
