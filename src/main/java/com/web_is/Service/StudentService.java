package com.web_is.Service;

import com.web_is.Respository.StudentRepository;
import com.web_is.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public void saveStudent(Student student) {
//        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
    }

    public Student findByRegistrationNumber(String registrationNumber) {
        return studentRepository.findByRegistrationNumber(registrationNumber);
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String registrationNumber) throws UsernameNotFoundException {
//        Student student = findByRegistrationNumber(registrationNumber);
//        if (student == null) {
//            throw new UsernameNotFoundException("Student not found");
//        }
//        return (UserDetails) student;
//    }
}
