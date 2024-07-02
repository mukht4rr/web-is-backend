package com.web_is.Respository;

import com.web_is.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // You can define custom query methods if needed
}
