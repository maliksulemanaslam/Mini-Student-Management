package com.student.mini_student_management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.mini_student_management.model.EnrollmentModel;

@Repository
public interface EnrollmentRepo extends JpaRepository<EnrollmentModel, Integer>{

    EnrollmentModel findByStudentStudentIdAndCourseCourseId(int studentId, int courseId);

    List<EnrollmentModel> findByStudentStudentId(int studentId);
}
