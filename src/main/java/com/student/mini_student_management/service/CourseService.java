package com.student.mini_student_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.mini_student_management.model.CourseModel;
import com.student.mini_student_management.repo.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    //Get all courses
    public List<CourseModel> getAllCourses(){
        return courseRepo.findAll();
    }

    //Add a new course
    public CourseModel addCourse(CourseModel course){
        return courseRepo.save(course);
    }

    //Update a course
    public CourseModel updateCourse(int id, CourseModel updatedCourse){
        CourseModel existingCourse = courseRepo.findById(id).orElse(null);
        if (existingCourse == null) {
            throw new IllegalArgumentException("Course not found");
        }
        existingCourse.setCourseName(updatedCourse.getCourseName());
        courseRepo.save(existingCourse);
        return existingCourse;
    }

    public void deleteCourse(int id) {
        CourseModel existingCourse = courseRepo.findById(id).orElse(null);
        if (existingCourse == null) {
            throw new IllegalArgumentException("Course not found");
        }
        courseRepo.deleteById(id);
    }

    public CourseModel getCourseById(int id) {
        CourseModel course = courseRepo.findById(id).orElse(null);
        return course;
    }
}
