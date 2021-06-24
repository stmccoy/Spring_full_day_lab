package CourseBookingLab.CourseBookingLab.controllers;

import CourseBookingLab.CourseBookingLab.models.Course;
import CourseBookingLab.CourseBookingLab.models.STAR_RATINGS;
import CourseBookingLab.CourseBookingLab.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(required = false, name = "rating") STAR_RATINGS rating,
            @RequestParam(required = false, name = "customer") String customer
    ){
        if (rating != null){
            return new ResponseEntity(courseRepository.findByRating(rating), HttpStatus.OK);
        } if (customer != null){
            return new ResponseEntity(courseRepository.findByBookingsCustomerName(StringUtils.capitalize(customer)), HttpStatus.OK);
        }
        else{
            List<Course> foundCourses = courseRepository.findAll();
            return new ResponseEntity<>(foundCourses, HttpStatus.OK);
        }
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
