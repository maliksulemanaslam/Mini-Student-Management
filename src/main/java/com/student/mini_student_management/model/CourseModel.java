package com.student.mini_student_management.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "courses")
public class CourseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @NotBlank(message = "Course name is required")
    @Size(min = 2, max = 100, message = "Course name must be between 2 and 100 characters")
    private String courseName;
    

    @OneToMany(mappedBy = "course" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "course-enrollment")
    private List<EnrollmentModel> enrollments;

    // Getters and Setters for enrollments
    public List<EnrollmentModel> getEnrollments() {
    return enrollments;
    }

    public void setEnrollments(List<EnrollmentModel> enrollments) {
    this.enrollments = enrollments;
    }

    //Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
