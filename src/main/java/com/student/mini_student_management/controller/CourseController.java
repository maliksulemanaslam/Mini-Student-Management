package com.student.mini_student_management.controller;

import java.util.List;

import jakarta.validation.*;
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

import com.student.mini_student_management.model.CourseModel;
import com.student.mini_student_management.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;
 
    //Get all courses
    @GetMapping("/courses")
    public ResponseEntity<List<CourseModel>> getAllCourses(){
     List<CourseModel> courses = courseService.getAllCourses();
     return ResponseEntity.ok(courses);
    }

    //Get a course by id
    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseModel> getCourseById(@PathVariable int id){
        CourseModel course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(course);
    }
 
    //Add a new course
    @PostMapping("/courses")
    public ResponseEntity<?> addCourse(@Valid @RequestBody CourseModel course){
     courseService.addCourse(course);
     return new ResponseEntity<>("Course added successfully", HttpStatus.OK);
    }
 
    //Update a course
    @PutMapping("/courses/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @Valid @RequestBody CourseModel course){
        CourseModel existingCourse = courseService.getCourseById(id);
        if (existingCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        courseService.updateCourse(id, course);
        return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
    }
 
    //Delete a course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        CourseModel existingCourse = courseService.getCourseById(id);
        if (existingCourse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        courseService.deleteCourse(id);
        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK);
    }
}
