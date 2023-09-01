package rest.api.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.api.example.entities.Courses;
import rest.api.example.services.CourseServiceImpl;

import  java.util.*;
@RestController
public class MyController {

    @Autowired

    private CourseServiceImpl courseService;



    @GetMapping("/home")

    public String home(){
        return "welcome to courses application";
    }


    @GetMapping("/courses")
    public List<Courses> getCourses(){
        return  this.courseService.getCourses();

    }

    @GetMapping("/courses/{courseId}")
    public  Courses getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));

    }
    @PostMapping(path="/courses",consumes = "application/json")
    public Courses addCourses(@RequestBody Courses courses){
        return this.courseService.addCourse(courses);

    }

    @PutMapping("/courses")
    public  Courses updateCourse(@RequestBody Courses courses){
        return this.courseService.updateCourse(courses);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(String coursreId){
        try{
            this.courseService.deleteCourse(Long.parseLong(coursreId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
