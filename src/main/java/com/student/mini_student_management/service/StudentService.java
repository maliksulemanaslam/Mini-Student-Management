package com.student.mini_student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mini_student_management.model.StudentModel;
import com.student.mini_student_management.repo.StudentRepo;

@Service
public class StudentService {
     
    @Autowired
    private StudentRepo studentRepo;

    //Get all students
    public List<StudentModel> getAllStudents(){
        return studentRepo.findAll();
    }

    public StudentModel getStudentById(int id) {
        StudentModel student = studentRepo.findById(id).orElse(null);
        return student;
    }

    public StudentModel getStudentWithEnrollmentDetails(int id) {
        StudentModel student = studentRepo.findById(id).orElse(null);
        return student;
    }

    //Add a new student
    public StudentModel addStudent(StudentModel student){
        return studentRepo.save(student);
    }

    //Update a student
    public StudentModel updateStudent(int id, StudentModel updatedStudent){
        StudentModel existingStudent = studentRepo.findById(id).orElse(null);
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student not found");
        }
        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setStudentEmail(updatedStudent.getStudentEmail());
        existingStudent.setStudentGrade(updatedStudent.getStudentGrade());
        studentRepo.save(existingStudent);
        return existingStudent;
    }

    public void deleteStudent(int id) {
        StudentModel existingStudent = studentRepo.findById(id).orElse(null);
        if (existingStudent == null) {
            throw new IllegalArgumentException("Student not found");
        }
        studentRepo.deleteById(id);
    }



}
