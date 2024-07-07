package com.web_is.Controller;

import com.web_is.Model.Attendance;
import com.web_is.Model.Enroll;
import com.web_is.Model.Student;
import com.web_is.Model.Course;
import com.web_is.Respository.CourseRepository;
import com.web_is.Respository.EnrollRepository;
import com.web_is.Respository.StudentRepository;
import com.web_is.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EnrollRepository enrollRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addAttendance(@RequestBody Attendance attendance) {
        // Check if the attendanceCode already exists for the same student
        boolean exists = attendanceService.existsByAttendanceCodeAndStudentId(attendance.getAttendanceCode(), attendance.getStudent_id());
        if (exists) {
            return ResponseEntity.status(409).body("Already Attend");
        }

        // Retrieve the associated Course entity
        Course course = courseRepository.findById(attendance.getCourse_id())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Check if the attendanceCode matches and the course status is not EXPIRED
        if (!course.getAttendanceCode().equals(attendance.getAttendanceCode()) || course.getAttendanceCodeStatus().equals("EXPIRED")) {
            return ResponseEntity.status(400).body("Invalid attendance code or code has expired");
        }

        // Retrieve the associated Enroll and Student entities
        Enroll enroll = enrollRepository.findById(attendance.getEnroll().getEnrollId())
                .orElseThrow(() -> new RuntimeException("Enroll not found"));
        Student student = studentRepository.findById(attendance.getStudent_id())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Set the entities to the Attendance object
        attendance.setEnroll(enroll);
        attendance.setStudent_id(student.getStudent_id());
        attendance.setCourse_id(course.getCourseId());

        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return ResponseEntity.ok("Attendance saved successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendancesByStudentId(@PathVariable Long studentId) {
        List<Attendance> attendances = attendanceService.getAttendancesByStudentId(studentId);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/lecturer/{lecturerId}")
    public ResponseEntity<List<Attendance>> getAttendancesByLecturerId(@PathVariable Long lecturerId) {
        List<Attendance> attendances = attendanceService.getAttendancesByLecturerId(lecturerId);
        return ResponseEntity.ok(attendances);
    }

}
