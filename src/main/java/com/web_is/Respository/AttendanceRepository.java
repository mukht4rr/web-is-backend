package com.web_is.Respository;

import com.web_is.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByAttendanceCodeAndStudentId(String attendanceCode, Long studentId);

    List<Attendance> findByStudentId(Long studentId);

    @Query("SELECT a FROM Attendance a " +
            "JOIN a.enroll e " +
            "JOIN e.course c " +
            "JOIN e.student s " +
            "JOIN LecturerCourse lc ON c.courseId = lc.course.courseId " +
            "JOIN lc.lecturer l " +
            "WHERE l.lecturerId = :lecturerId")
    List<Attendance> findByLecturerId(@Param("lecturerId") Long lecturerId);

}
