package com.web_is.Respository;

import com.web_is.Model.Enroll;
import com.web_is.Model.LecturerCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollRepository extends JpaRepository<Enroll, Long> {
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Enroll e WHERE e.student.student_id = :studentId AND e.course.courseId = :courseId")
    boolean existsByStudentIdAndCourseId(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    @Query("SELECT e FROM Enroll e JOIN FETCH e.course WHERE e.student.student_id = :studentId")
    List<Enroll> findEnrollmentsByStudentId(@Param("studentId") Long studentId);


}