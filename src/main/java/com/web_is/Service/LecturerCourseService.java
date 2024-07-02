package com.web_is.Service;

import com.web_is.Model.Course;
import com.web_is.Model.LecturerCourse;
import com.web_is.Respository.CourseRepository;
import com.web_is.Respository.LecturerCourseRepository;
import com.web_is.Respository.LecturerRepository;
import com.web_is.Model.Lecturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LecturerCourseService {

    @Autowired
    private LecturerCourseRepository lecturerCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Transactional
    public void assignCourseToLecturer(Long lecturerId, Long courseId) {
        // Fetch course and lecturer entities
        Course course = courseRepository.findById(Math.toIntExact(courseId))
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Lecturers lecturer = lecturerRepository.findById(Math.toIntExact(lecturerId))
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        // Create and save lecturerCourse entity
        LecturerCourse lecturerCourse = new LecturerCourse();
        lecturerCourse.setLecturer(lecturer);
        lecturerCourse.setCourse(course);

        lecturerCourseRepository.save(lecturerCourse);
    }

    public List<LecturerCourse> getAllLecturerCourses() {
        return lecturerCourseRepository.findAll();
    }

    public List<LecturerCourse> getAllLecturerCoursesWithDetails() {
        return lecturerCourseRepository.findAllWithDetails();
    }

    public List<LecturerCourse> getLecturerCoursesByLecturerId(Long lecturerId) {
        return lecturerCourseRepository.findByLecturerLecturerId(lecturerId);
    }

}
