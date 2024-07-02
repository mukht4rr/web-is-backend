package com.web_is.Controller;

import com.web_is.Service.LecturerCourseService;
import com.web_is.Model.LecturerCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lecturer-course")
public class LecturerCourseController {

    @Autowired
    private LecturerCourseService lecturerCourseService;

    @PostMapping("/assign")
    public void assignCourseToLecturer(@RequestBody Map<String, Long> assignment) {
        Long lecturerId = assignment.get("lecturerId");
        Long courseId = assignment.get("courseId");
        lecturerCourseService.assignCourseToLecturer(lecturerId, courseId);
    }

    @GetMapping("/getLecturerCourses")
    public List<LecturerCourse> getAllLecturerCoursesWithDetails() {
        return lecturerCourseService.getAllLecturerCoursesWithDetails();
    }

    @GetMapping("/getLecturerCoursesById/{lecturerId}")
    public List<LecturerCourse> getLecturerCourses(@PathVariable Long lecturerId) {
        return lecturerCourseService.getLecturerCoursesByLecturerId(lecturerId);
    }


}
