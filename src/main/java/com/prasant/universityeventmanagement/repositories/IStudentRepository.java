package com.prasant.universityeventmanagement.repositories;

import com.prasant.universityeventmanagement.models.Departments;
import com.prasant.universityeventmanagement.models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer> {

    @Modifying
    @Query(value = "update students set department = :department where student_id = :id", nativeQuery = true)
    public void updateDepartmentById(String department, Integer id);
}
