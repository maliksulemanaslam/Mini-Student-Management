package com.student.mini_student_management.DTOs;

public class StudentEnrollmentDTO {

        private int enrollmentId;
        private int courseId;
        private String courseName;
        private String grade;
        
        // Getters and setters
        public int getEnrollmentId(){
            return enrollmentId;
        }

        public void setEnrollmentId(int enrollmentId){
            this.enrollmentId = enrollmentId;
        }

        public int getCourseId(){
            return courseId;
        }

        public void setCourseId(int courseId){
            this.courseId = courseId;
        }

        public String getCourseName(){
            return courseName;
        }

        public void setCourseName(String courseName){
            this.courseName = courseName;
        }

        public String getGrade(){
            return grade;
        }

        public void setGrade(String grade){
            this.grade = grade;
        }
        
    
}
