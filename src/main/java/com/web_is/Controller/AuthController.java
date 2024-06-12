//package com.web_is.Controller;
//
//import com.web_is.Service.StudentService;
//import com.web_is.User.Student;
//import com.web_is.Service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
////    @Autowired
////    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private UserService userService;
//
////    @PostMapping("/login")
////    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
////        try {
////            Authentication authentication = authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
////            );
////            SecurityContextHolder.getContext().setAuthentication(authentication);
////            return ResponseEntity.ok("Login successful");
////        } catch (Exception e) {
////            e.printStackTrace();
////            return ResponseEntity.status(401).body("Login failed. Please check your credentials.");
////        }
////    }
////
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Student student) {
//        if (student.getFullname() == null || student.getFullname().isEmpty() && student.getRegistrationNumber() == null || student.getRegistrationNumber().isEmpty()) {
//            return ResponseEntity.badRequest().body("All fields are required");
//        }
//
//        if (studentService.findByRegistrationNumber(student.getRegistrationNumber()) != null) {
//            return ResponseEntity.badRequest().body("Already Registered");
//        }
//
//        studentService.save(student);
//        return ResponseEntity.ok("Student registered successfully");
//    }
//
//    public static class LoginRequest {
//        private String username;
//        private String password;
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }
//}
