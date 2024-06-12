package com.web_is.Controller;

import com.web_is.Service.CourseService;
import com.web_is.User.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //INSERT COURSES
    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        try {
            Course savedCourse = courseService.saveCourse(course);
            return ResponseEntity.ok(savedCourse);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return ResponseEntity.status(500).body(null);
        }
    }

    //RETRIEVE ALL COURSES
    @GetMapping("/get") // Change "/add" to something like "/get"
    public List<Course> getCourse() {
        try {
            return courseService.getAllCourses();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return (List<Course>) ResponseEntity.status(500).body(null);
        }
    }

    //COUNT TOTAL COURSES
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalCourse() {
        try {
            long totalCourse = courseService.countCourses();
            return ResponseEntity.ok(totalCourse);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return ResponseEntity.status(500).body(null);
        }
    }

    //UPDATE THE COURSE STATUS
    @PutMapping("/update/{courseId}")
    public ResponseEntity<Course> updateCourseStatus(@PathVariable int courseId, @RequestBody Map<String, String> statusMap) {
        try {
            Optional<Course> optionalCourse = courseService.getCourseById(courseId);
            if (optionalCourse.isPresent()) {
                Course course = optionalCourse.get();
                course.setStatus(statusMap.get("status"));
                Course updatedCourse = courseService.saveCourse(course);
                return ResponseEntity.ok(updatedCourse);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return ResponseEntity.status(500).body(null);
        }
    }

    //DELETE COURSE
    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) {
        try {
            courseService.deleteCourse(courseId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return ResponseEntity.status(500).build();
        }
    }



}
