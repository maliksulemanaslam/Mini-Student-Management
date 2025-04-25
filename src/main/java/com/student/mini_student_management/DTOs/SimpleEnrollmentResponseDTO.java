package com.student.mini_student_management.DTOs;

public class SimpleEnrollmentResponseDTO {
    private StudentRef student;
    private CourseRef course;
    private String grade;
    
    // Nested classes for references
    public static class StudentRef {
        private int studentId;
        
        public StudentRef() {}
        
        public StudentRef(int studentId) {
            this.studentId = studentId;
        }
        
        public int getStudentId() {
            return studentId;
        }
        
        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }
    }
    
    public static class CourseRef {
        private int courseId;
        
        public CourseRef() {}
        
        public CourseRef(int courseId) {
            this.courseId = courseId;
        }
        
        public int getCourseId() {
            return courseId;
        }
        
        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    }
    
    // Getters and setters for main class
    public StudentRef getStudent() {
        return student;
    }
    
    public void setStudent(StudentRef student) {
        this.student = student;
    }
    
    public CourseRef getCourse() {
        return course;
    }
    
    public void setCourse(CourseRef course) {
        this.course = course;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
