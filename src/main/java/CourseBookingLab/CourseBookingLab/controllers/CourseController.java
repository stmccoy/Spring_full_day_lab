package CourseBookingLab.CourseBookingLab.controllers;

import CourseBookingLab.CourseBookingLab.models.Course;
import CourseBookingLab.CourseBookingLab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> foundCourses = courseRepository.findAll();
        return new ResponseEntity<>(foundCourses, HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity getCourseById(@PathVariable Long id){
        Optional<Course> foundCourse = courseRepository.findById(id);
        return new ResponseEntity(foundCourse, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
}
