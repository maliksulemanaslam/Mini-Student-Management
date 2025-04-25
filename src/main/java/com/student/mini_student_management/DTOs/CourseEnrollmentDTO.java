package com.student.mini_student_management.DTOs;

public class CourseEnrollmentDTO {

    private int enrollmentId;
    private int studentId;
    private String studentName;
    private String grade;
    
    // Getters and setters
    public int getEnrollmentId(){
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId){
        this.enrollmentId = enrollmentId;
    }

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

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }
}
