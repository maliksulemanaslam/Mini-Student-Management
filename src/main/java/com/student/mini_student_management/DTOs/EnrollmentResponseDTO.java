package com.student.mini_student_management.DTOs;

public class EnrollmentResponseDTO {
    private int id;
    private StudentBasicDTO student;
    private CourseBasicDTO course;
    private String grade;
    
    // Create nested DTOs for Student and Course
    public static class StudentBasicDTO {
        private int studentId;
        private String studentName;
        private String studentEmail;
        private String studentGrade;
        
        // Getters and setters
        public int getStudentId() { return studentId; }
        public void setStudentId(int studentId) { this.studentId = studentId; }
        public String getStudentName() { return studentName; }
        public void setStudentName(String studentName) { this.studentName = studentName; }
        public String getStudentEmail() { return studentEmail; }
        public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }
        public String getStudentGrade() { return studentGrade; }
        public void setStudentGrade(String studentGrade) { this.studentGrade = studentGrade; }
    }
    
    public static class CourseBasicDTO {
        private int courseId;
        private String courseName;
        
        // Getters and setters
        public int getCourseId() { return courseId; }
        public void setCourseId(int courseId) { this.courseId = courseId; }
        public String getCourseName() { return courseName; }
        public void setCourseName(String courseName) { this.courseName = courseName; }
    }
    
    // Getters and setters for main class
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public StudentBasicDTO getStudent() { return student; }
    public void setStudent(StudentBasicDTO student) { this.student = student; }
    public CourseBasicDTO getCourse() { return course; }
    public void setCourse(CourseBasicDTO course) { this.course = course; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
