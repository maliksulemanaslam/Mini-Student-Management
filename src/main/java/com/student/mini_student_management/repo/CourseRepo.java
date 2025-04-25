package com.student.mini_student_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.mini_student_management.model.CourseModel;

//JPA Repository for Course Model
//Automatically provides CRUD operations

@Repository
public interface CourseRepo extends JpaRepository<CourseModel, Integer>{

}
