package com.student.mini_student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.mini_student_management.model.StudentModel;


//JPA Repository for Student Model
//Automatically provides CRUD operations

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Integer>{

}
