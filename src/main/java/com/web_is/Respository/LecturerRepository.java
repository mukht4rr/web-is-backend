package com.web_is.Respository;

import com.web_is.Model.Lecturers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturers, Integer> {
    Lecturers findByLecturerEmail(String lecturerEmail);
}
