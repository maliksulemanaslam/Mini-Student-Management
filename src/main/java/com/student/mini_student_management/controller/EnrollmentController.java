package com.student.mini_student_management.controller;

import java.util.List;

import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.mini_student_management.DTOs.GradeDTO;
import com.student.mini_student_management.model.EnrollmentModel;
import com.student.mini_student_management.service.EnrollmentService;
import com.student.mini_student_management.DTOs.SimpleEnrollmentResponseDTO;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {
    
    @Autowired
    private EnrollmentService enrollmentService;

    // Retrieve all enrollments with details
    @GetMapping
    public ResponseEntity<?> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollmentsWithDetails());
    }

    // Enroll a student in a course
    @PostMapping
    public ResponseEntity<?> enrollStudent(@Valid @RequestBody EnrollmentModel enrollment) {
        if (enrollment.getStudent() == null || enrollment.getCourse() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student or course");
        }
        return ResponseEntity.ok(enrollmentService.enrollStudentSimple(enrollment));
    }

    // Update a student's grade for a course
    @PutMapping("/student/{studentId}/course/{courseId}/grade")
    public ResponseEntity<?> updateGrade(@PathVariable int studentId, @PathVariable int courseId, @Valid @RequestBody GradeDTO gradeDTO) {
        if (studentId <= 0 || courseId <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid student or course ID");
        }
        SimpleEnrollmentResponseDTO enrollment = enrollmentService.updateGradeSimple(studentId, courseId, gradeDTO.getGrade());
        if (enrollment != null) {
            return ResponseEntity.ok(enrollment);
        }
        return ResponseEntity.notFound().build();
    }  
}
