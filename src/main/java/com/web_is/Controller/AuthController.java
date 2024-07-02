package com.web_is.Controller;

import com.web_is.Service.LecturerService;
import com.web_is.Service.StudentService;
import com.web_is.Service.UserService;
import com.web_is.Model.Lecturers;
import com.web_is.Model.Student;
import com.web_is.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LecturerService lecturerService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user, HttpSession session) {
        User foundUser = userService.findByUsername(user.getUsername());

        Map<String, String> response = new HashMap<>();

        if (foundUser == null) {
            response.put("message", "User not found");
            return ResponseEntity.badRequest().body(response);
        }

        if (foundUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", foundUser);

            // Get the user's role and include it in the response
            User userRoles = foundUser;
            User userName = foundUser;
            response.put("message", "Login successful");
            response.put("role", userRoles.getRole());
            response.put("name", userName.getUsername());

            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/lecturerLogin")
    public ResponseEntity<Map<String, String>> lecturerLogin(@RequestBody Lecturers lecturers, HttpSession session) {
        Lecturers foundLecturer = lecturerService.findByEmail(lecturers.getLecturerEmail());

        Map<String, String> response = new HashMap<>();

        if (foundLecturer == null) {
            response.put("message", "Lecturer not found");
            return ResponseEntity.badRequest().body(response);
        }

        if (foundLecturer.getLecturerPassword().equals(lecturers.getLecturerPassword())) {
            session.setAttribute("lecturer", foundLecturer);
            response.put("message", "Login successful");
            response.put("role", "lecturer");
            response.put("lecturerId", String.valueOf(foundLecturer.getLecturerId())); // Return lecturer ID
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/studentLogin")
    public ResponseEntity<Map<String, String>> studentLogin(@RequestBody Student student, HttpSession session) {
        Student foundStudent = studentService.findByRegistrationNumber(student.getRegistrationNumber());

        Map<String, String> response = new HashMap<>();

        if (foundStudent == null) {
            response.put("message", "Student not found");
            return ResponseEntity.badRequest().body(response);
        }

        if (foundStudent.getPassword().equals(student.getPassword())) {
            session.setAttribute("student", foundStudent);
            response.put("message", "Login successful");
            response.put("role", "student");
            response.put("studentId", String.valueOf(foundStudent.getId()));
            response.put("studentName", foundStudent.getFullname());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid credentials");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/checkSession")
    public ResponseEntity<Map<String, String>> checkSession(HttpSession session) {
        Map<String, String> response = new HashMap<>();
        if (session.getAttribute("user") != null) {
            response.put("message", "User is logged in");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "User is not logged in");
            return ResponseEntity.status(401).body(response);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Student newStudent) {
        Student existingUser = studentService.findByRegistrationNumber(newStudent.getRegistrationNumber());
        Map<String, String> response = new HashMap<>();
        if (existingUser != null) {
            response.put("message", "Registration number already exists");
            return ResponseEntity.badRequest().body(response);
        }
        studentService.saveStudent(newStudent);
        response.put("message", "Registration successful");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTotalStudents() {
        try {
            long totalStudents = studentService.countStudents();
            return ResponseEntity.ok(totalStudents);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/get")
    public List<Student> getStudent() {
        try {
            return studentService.getAllStudents();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception details for debugging
            return (List<Student>) ResponseEntity.status(500).body(null);
        }
    }
}
