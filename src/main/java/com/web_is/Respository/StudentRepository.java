package com.web_is.Respository;

import com.web_is.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRegistrationNumber(String registrationNumber);
}
