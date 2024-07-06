package com.web_is.Service;

import com.web_is.Respository.CourseRepository;
import com.web_is.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int courseId) {
        return courseRepository.findById(courseId);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }

    public long countCourses() {
        return courseRepository.count();
    }

    // New method to get courses by status
    public List<Course> getCoursesByStatus(String status) {
        return courseRepository.findByStatus(status);
    }

    public Course generateAttendanceCode(int courseId, String code) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setAttendanceCode(code);
            course.setAttendanceCodeStatus("ACTIVE");
            course.setDate(LocalDateTime.now());
            return courseRepository.save(course);
        } else {
            return null;
        }
    }

    @Scheduled(fixedRate = 30000)
    public void expireAttendanceCodes() {
        List<Course> courses = courseRepository.findByAttendanceCodeStatus("ACTIVE");
        LocalDateTime now = LocalDateTime.now();
        for (Course course : courses) {
            if (course.getDate().plusSeconds(30).isBefore(now)) {
                course.setAttendanceCodeStatus("EXPIRED");
                courseRepository.save(course);
            }
        }
    }

}
