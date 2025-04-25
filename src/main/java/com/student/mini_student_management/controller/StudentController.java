package com.student.mini_student_management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.mini_student_management.DTOs.StudentEnrollmentDTO;
import com.student.mini_student_management.model.StudentModel;
import com.student.mini_student_management.service.EnrollmentService;
import com.student.mini_student_management.service.StudentService;

@RestController
public class StudentController {
   @Autowired
   private StudentService studentService;
   @Autowired
   private EnrollmentService enrollmentService;


   //Get all students
   @GetMapping("/students")
   public ResponseEntity<List<StudentModel>> getAllStudents(){
    List<StudentModel> students = studentService.getAllStudents();
    return ResponseEntity.ok(students);
   }

   //Get a student by id
   @GetMapping("/students/{id}")
   public ResponseEntity<?> getStudentById(@PathVariable int id){
      StudentModel student = studentService.getStudentById(id);
      if (student == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }

      // Get detailed enrollments for this student
    List<StudentEnrollmentDTO> enrollments = enrollmentService.getStudentEnrollmentsWithCourseDetails(id);
    
    // Create response with student info and detailed enrollments
    Map<String, Object> response = new HashMap<>();
    response.put("studentId", student.getStudentId());
    response.put("studentName", student.getStudentName());
    response.put("studentEmail", student.getStudentEmail());
    response.put("studentGrade", student.getStudentGrade());
    response.put("enrollments", enrollments);
    
    return ResponseEntity.ok(response);
   }


   //Add a new student
   @PostMapping("/students")
   public ResponseEntity<?> addStudent(@Valid @RequestBody StudentModel student){
    studentService.addStudent(student);
    return new ResponseEntity<>("Student added successfully", HttpStatus.OK);
   }

   //Update a student
   @PutMapping("/students/{id}")
   public ResponseEntity<String> updateStudent(@PathVariable int id, @Valid @RequestBody StudentModel student){
    StudentModel existingStudent = studentService.getStudentById(id);
    if (existingStudent == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
    studentService.updateStudent(id, student);
    return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
   }

   //Delete a student
   @DeleteMapping("/students/{id}")
   public ResponseEntity<String> deleteStudent(@PathVariable int id){
    StudentModel existingStudent = studentService.getStudentById(id);
    if (existingStudent == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
    studentService.deleteStudent(id);
    return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
   }

   @GetMapping("/students/{id}/courses")
   public ResponseEntity<?> getStudentWithCourses(@PathVariable int id) {
    List<StudentEnrollmentDTO> enrollments = enrollmentService.getStudentEnrollmentsWithCourseDetails(id);
    if (!enrollments.isEmpty()) {
      return ResponseEntity.ok(enrollments);
    }
   return ResponseEntity.notFound().build();
   }

}
