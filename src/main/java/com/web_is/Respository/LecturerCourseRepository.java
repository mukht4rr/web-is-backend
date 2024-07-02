package com.web_is.Respository;

import com.web_is.Model.LecturerCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerCourseRepository extends JpaRepository<LecturerCourse, Long> {

    @Query("SELECT lc FROM LecturerCourse lc JOIN FETCH lc.course JOIN FETCH lc.lecturer")
    List<LecturerCourse> findAllWithDetails();

    @Query("SELECT lc FROM LecturerCourse lc JOIN FETCH lc.course WHERE lc.lecturer.lecturerId = :lecturerId")
    List<LecturerCourse> findByLecturerLecturerId(@Param("lecturerId") Long lecturerId);


}
