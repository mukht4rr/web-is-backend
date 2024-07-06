package com.web_is.Service;

import com.web_is.Model.Course;
import com.web_is.Model.Enroll;
import com.web_is.Model.LecturerCourse;
import com.web_is.Model.Student;
import com.web_is.Respository.CourseRepository;
import com.web_is.Respository.EnrollRepository;
import com.web_is.Respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollRepository enrollRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public boolean enrollStudent(Long courseId, Long studentId, String enrollmentKey) {
        Course course = courseRepository.findById(Math.toIntExact(courseId)).orElse(null);
        if (course != null && course.getEnrollmentKey().equals(enrollmentKey)) {
            Student student = studentRepository.findById(studentId).orElse(null);
            if (student != null) {
                if (enrollRepository.existsByStudentIdAndCourseId(studentId, courseId)) {
                    return false; // Enrollment already exists
                }
                Enroll enroll = new Enroll();
                enroll.setCourse(course);
                enroll.setStudent(student);
                enrollRepository.save(enroll);
                return true; // Enrollment successful
            }
        }
        return false; // Invalid enrollment key or other error
    }

    public List<Enroll> getEnrollmentsByStudentId(Long studentId) {
        return enrollRepository.findEnrollmentsByStudentId(studentId);
    }

}