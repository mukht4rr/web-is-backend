package com.web_is.Service;

import com.web_is.Model.Attendance;
import com.web_is.Respository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public boolean existsByAttendanceCodeAndStudentId(String attendanceCode, Long studentId) {
        return attendanceRepository.existsByAttendanceCodeAndStudentId(attendanceCode, studentId);
    }

    public List<Attendance> getAttendancesByStudentId(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

}
