package com.web_is.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enroll_id", nullable = false)
    private Enroll enroll;

    @JoinColumn(name = "course_id", nullable = false)
    private Integer course_id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "attendance_code")
    private String attendanceCode;

    // Getters and setters

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Enroll getEnroll() {
        return enroll;
    }

    public void setEnroll(Enroll enroll) {
        this.enroll = enroll;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Long getStudent_id() {
        return studentId;
    }

    public void setStudent_id(Long studentId) {
        this.studentId = studentId;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }
}
