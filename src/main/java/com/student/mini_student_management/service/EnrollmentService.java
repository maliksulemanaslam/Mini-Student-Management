package com.student.mini_student_management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mini_student_management.DTOs.EnrollmentResponseDTO;
import com.student.mini_student_management.DTOs.SimpleEnrollmentResponseDTO;
import com.student.mini_student_management.DTOs.StudentEnrollmentDTO;
import com.student.mini_student_management.model.EnrollmentModel;
import com.student.mini_student_management.repo.EnrollmentRepo;

@Service
public class EnrollmentService {
    
    @Autowired
    private EnrollmentRepo enrollmentRepo;

    // Retrieve all enrollments with detailed information
    public List<EnrollmentResponseDTO> getAllEnrollmentsWithDetails() {
        List<EnrollmentModel> enrollments = enrollmentRepo.findAll();
        List<EnrollmentResponseDTO> dtos = new ArrayList<>();
        
        for (EnrollmentModel enrollment : enrollments) {
            EnrollmentResponseDTO dto = new EnrollmentResponseDTO();
            dto.setId(enrollment.getId());
            dto.setGrade(enrollment.getGrade());
            
            // Set student info
            EnrollmentResponseDTO.StudentBasicDTO studentDTO = new EnrollmentResponseDTO.StudentBasicDTO();
            studentDTO.setStudentId(enrollment.getStudent().getStudentId());
            studentDTO.setStudentName(enrollment.getStudent().getStudentName());
            studentDTO.setStudentEmail(enrollment.getStudent().getStudentEmail());
            studentDTO.setStudentGrade(enrollment.getStudent().getStudentGrade());
            dto.setStudent(studentDTO);
            
            // Set course info
            EnrollmentResponseDTO.CourseBasicDTO courseDTO = new EnrollmentResponseDTO.CourseBasicDTO();
            courseDTO.setCourseId(enrollment.getCourse().getCourseId());
            courseDTO.setCourseName(enrollment.getCourse().getCourseName());
            dto.setCourse(courseDTO);
            
            dtos.add(dto);
        }
        
        return dtos;
    }

    // Enroll a student in a course
    public EnrollmentModel enrollStudent(EnrollmentModel enrollment) {
        if (enrollment.getStudent() == null || enrollment.getCourse() == null) {
            throw new IllegalArgumentException("Invalid student or course");
        }
        return enrollmentRepo.save(enrollment);
    }

    // Enroll a student with a simple response
    public SimpleEnrollmentResponseDTO enrollStudentSimple(EnrollmentModel enrollment) {
        EnrollmentModel savedEnrollment = enrollmentRepo.save(enrollment);
        
        SimpleEnrollmentResponseDTO dto = new SimpleEnrollmentResponseDTO();
        dto.setGrade(savedEnrollment.getGrade());
        
        SimpleEnrollmentResponseDTO.StudentRef studentRef = 
            new SimpleEnrollmentResponseDTO.StudentRef(savedEnrollment.getStudent().getStudentId());
        dto.setStudent(studentRef);
        
        SimpleEnrollmentResponseDTO.CourseRef courseRef = 
            new SimpleEnrollmentResponseDTO.CourseRef(savedEnrollment.getCourse().getCourseId());
        dto.setCourse(courseRef);
        
        return dto;
    }
  
    // Update a student's grade for a course
    public SimpleEnrollmentResponseDTO updateGradeSimple(int studentId, int courseId, String grade) {
        EnrollmentModel enrollment = enrollmentRepo.findByStudentStudentIdAndCourseCourseId(studentId, courseId);
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment not found");
        }
        enrollment.setGrade(grade);
        EnrollmentModel updatedEnrollment = enrollmentRepo.save(enrollment);
        SimpleEnrollmentResponseDTO dto = new SimpleEnrollmentResponseDTO();
        dto.setGrade(updatedEnrollment.getGrade());
        SimpleEnrollmentResponseDTO.StudentRef studentRef = new SimpleEnrollmentResponseDTO.StudentRef(updatedEnrollment.getStudent().getStudentId());
        dto.setStudent(studentRef);
        SimpleEnrollmentResponseDTO.CourseRef courseRef = new SimpleEnrollmentResponseDTO.CourseRef(updatedEnrollment.getCourse().getCourseId());
        dto.setCourse(courseRef);
        return dto;
    }

    // Retrieve enrollments for a student with course details
    public List<StudentEnrollmentDTO> getStudentEnrollmentsWithCourseDetails(int studentId) {
        List<EnrollmentModel> enrollments = enrollmentRepo.findByStudentStudentId(studentId);
        List<StudentEnrollmentDTO> dtos = new ArrayList<>();
        
        for (EnrollmentModel enrollment : enrollments) {
            StudentEnrollmentDTO dto = new StudentEnrollmentDTO();
            dto.setEnrollmentId(enrollment.getId());
            dto.setCourseId(enrollment.getCourse().getCourseId());
            dto.setCourseName(enrollment.getCourse().getCourseName());
            dto.setGrade(enrollment.getGrade());
            dtos.add(dto);
        }
        
        return dtos;
    }
}
