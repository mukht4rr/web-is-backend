package com.web_is.Controller;

import com.web_is.Model.Enroll;
import com.web_is.Service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    //student enroll in a specific course
    @PostMapping("/enroll")
    public ResponseEntity<?> enrollStudent(@RequestBody Map<String, Object> requestData) {
        Long courseId = Long.valueOf(requestData.get("courseId").toString());
        Long studentId = Long.valueOf(requestData.get("studentId").toString());
        String enrollmentKey = requestData.get("enrollmentKey").toString();

        boolean result = enrollService.enrollStudent(courseId, studentId, enrollmentKey);
        if (result) {
            return ResponseEntity.ok().body("Enrollment successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid enrollment key or enrollment already exists");
        }
    }

    @GetMapping("/enrolledCourses/{studentId}")
    public ResponseEntity<List<Enroll>> getEnrolledCourses(@PathVariable Long studentId) {
        List<Enroll> enrolledCourses = enrollService.getEnrollmentsByStudentId(studentId);
        if (enrolledCourses.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(enrolledCourses, HttpStatus.OK);
    }

}
