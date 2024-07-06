package com.web_is.Respository;

import com.web_is.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("SELECT c FROM Course c WHERE c.status = :status")
    List<Course> findByStatus(@Param("status") String status);

    @Query("SELECT c FROM Course c WHERE c.attendanceCodeStatus = :status")
    List<Course> findByAttendanceCodeStatus(@Param("status") String status);
}
