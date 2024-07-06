package com.web_is.Respository;

import com.web_is.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByAttendanceCodeAndStudentId(String attendanceCode, Long studentId);

    List<Attendance> findByStudentId(Long studentId);
}
