package com.student.mini_student_management.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


//Student Model
//Represents the Student Entity


@Entity
@Table(name = "students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @NotBlank(message = "Student name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String studentName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String studentEmail;

    @NotNull(message = "Grade is required")
    private String studentGrade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "student-enrollment")
    private List<EnrollmentModel> enrollments;

    // Getters and Setters for enrollments
    public List<EnrollmentModel> getEnrollments() {
    return enrollments;
    }

    public void setEnrollments(List<EnrollmentModel> enrollments) {
    this.enrollments = enrollments;
    }


    //Getters and Setters
    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getStudentEmail(){
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail){
        this.studentEmail = studentEmail;
    }

    public String getStudentGrade(){
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade){
        this.studentGrade = studentGrade;
    }
}
